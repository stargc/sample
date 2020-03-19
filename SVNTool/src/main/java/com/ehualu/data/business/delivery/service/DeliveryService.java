package com.ehualu.data.business.delivery.service;

import com.ehualu.data.business.delivery.dao.DeliveryMapper;
import com.ehualu.data.business.delivery.model.Delivery;
import com.ehualu.data.business.delivery.model.DeliveryExample;
import com.ehualu.data.business.delivery.model.DeliveryReq;
import com.ehualu.data.business.product.service.ProductService;
import com.ehualu.data.business.repositories.model.RepositoriesConfig;
import com.ehualu.data.business.repositories.service.RepositoriesService;
import com.ehualu.data.business.role.model.UserRole;
import com.ehualu.data.business.role.service.UserRoleService;
import com.ehualu.data.business.svn.model.FilePermission;
import com.ehualu.data.business.svn.service.SVNFileService;
import com.ehualu.data.business.svn.service.SVNPermissionService;
import com.ehualu.data.business.svnuser.service.SvnUserService;
import com.ehualu.data.common.exception.MessageException;
import com.ehualu.data.common.filter.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author created by guanchen on 2020/3/19 10:00
 */
@Service
@Slf4j
public class DeliveryService {

    private String DELIVERY_STATUS_DONE = "0";
    private String DELIVERY_STATUS_OVERDUE = "1";
    private String DELIVERY_BASE_PATH = "/temp";
    private String SVN_DB_PERMISSION_FILE = "/conf/VisualSVN-SvnAuthz.ini";
    private String SYMBOL = "/";

    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private SVNFileService svnFileService;
    @Autowired
    private RepositoriesService repositoriesService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SVNPermissionService svnPermissionService;
    @Autowired
    private SvnUserService svnUserService;
    @Autowired
    private UserRoleService userRoleService;


    public void delivery(DeliveryReq req){
        /** 获取用户名和用户ID list*/
        List<String> userIDList = Arrays.stream(req.getSvnUserids().split(",")).collect(Collectors.toList());
        List<String> userNameList = userIDList.stream().map(id -> svnUserService.selectById(Integer.valueOf(id)).getUserName()).filter(StringUtils::isNotBlank).collect(Collectors.toList());

        /** 生成原始文件 svn访问地址*/
        RepositoriesConfig config = repositoriesService.getRepConfig();
        String svnBasePath = config.getAccessBaseUrl();
        String sourcePath = productService.searchById(req.getProductId()).getRepositoryUrl();

        /** 生成出库文件 svn访问地址*/
        String deliveryPath = new StringBuilder()
                .append(DELIVERY_BASE_PATH)
                .append(sourcePath)
                .append(SYMBOL)
                .append(System.currentTimeMillis()).toString();

        /** svn进行copy操作*/
        try {
            svnFileService.doCopy(svnBasePath + sourcePath, svnBasePath + deliveryPath);
        } catch (SVNException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw  new MessageException("执行操作错误");
        }

        /**  给用户添加指定权限*/
        svnPermissionService.addPermission2File(config.getDbBasePath() + SVN_DB_PERMISSION_FILE,
                deliveryPath,userNameList, FilePermission.READ.getCode());

        /** 添加出库记录表*/
        Delivery delivery = new Delivery();
        delivery.setCreateTime(new Date());
        delivery.setCreateUserId(RequestHolder.getUserId());
        delivery.setOverdueTime(req.getOverdueDate());
        delivery.setProductId(req.getProductId());
        delivery.setProjectCode(req.getProjectCode());
        delivery.setProjectName(req.getProjectName());
        delivery.setStatus(DELIVERY_STATUS_DONE);
        delivery.setDeliveryPath(svnBasePath + deliveryPath);
        deliveryMapper.insertSelective(delivery);

        /** 添加用户权限表*/
        userIDList.stream().forEach(userID ->{
            UserRole role = new UserRole();
            role.setAccess(FilePermission.READ.getCode());
            role.setUserId(Integer.valueOf(userID));
            role.setDeliveryId(delivery.getId());
            userRoleService.add(role);
        });
    }

    public void deleteOverdue(){
        DeliveryExample example = new DeliveryExample();
        example.createCriteria().andStatusEqualTo(DELIVERY_STATUS_DONE).andOverdueTimeLessThan(new Date());
        List<Delivery> deliveryList = deliveryMapper.selectByExample(example);
        if (deliveryList.isEmpty()) return;

        RepositoriesConfig config = repositoriesService.getRepConfig();
        final int[] successCount = {0};
        deliveryList.stream().forEach(delivery -> {
            try {
                svnFileService.doDelete(delivery.getDeliveryPath());
                String[] deliverPath = delivery.getDeliveryPath().split(config.getAccessBaseUrl());
                svnPermissionService.deletePermission(config.getDbBasePath() + SVN_DB_PERMISSION_FILE,deliverPath[1]);

                delivery.setStatus(DELIVERY_STATUS_OVERDUE);
                DeliveryExample updateExample = new DeliveryExample();
                updateExample.createCriteria().andIdEqualTo(delivery.getId());
                deliveryMapper.updateByExampleSelective(delivery,updateExample);
                successCount[0]++;
            } catch (SVNException e) {
                log.error(ExceptionUtils.getStackTrace(e));
            }
        });
        log.info(String.format("处理过期出库数据，总条数{%d}成功条数{%d}",deliveryList.size(), successCount[0]));
    }
}

package com.ehl.tsq.data.business.service.ZHCG.trash;

import com.alibaba.fastjson.JSON;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGTrashMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.DtsjCsglCsjcssjc;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrash;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrashExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/28 15:21
 */
@Service
@Slf4j
public class TrasheService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZHCGTrashMapper trashMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;

    @Value("${ZHCG.trashes_page}")
    private String trashesPageUrl;

    public void queryTransheInfo(){
        ZHCGResp<List<Map<String, String>>> resp =
                restTemplate.getForObject(trashesPageUrl + "?start=1&limit=200", ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取垃圾桶基础信息 接口返回内容为空");
            return;
        }
        log.info("获取垃圾桶条数：" + resp.getTotalCount());
        List<Map<String, String>> trashList = resp.getData();
        trashList.stream().forEach(map -> {
            ZHCGTrash trash = JSON.parseObject(JSON.toJSONString(map), ZHCGTrash.class);

            ZHCGTrashExample example = new ZHCGTrashExample();
            example.createCriteria().andTrashIdEqualTo(trash.getTrashId());
            List<ZHCGTrash> exitList = trashMapper.selectByExample(example);
            if (!exitList.isEmpty()){
                if (!exitList.get(0).getNumber().equals(trash.getNumber())){
                    trash.setUpdateTime(new Date());
                    trashMapper.updateByExampleSelective(trash,example);
                }
                log.info("调用 获取公厕基础信息(" + trash.getTrashId() + ")无变化");
            } else {
                trash.setCreateTime(new Date());
                trashMapper.insertSelective(trash);
                DtsjCsglCsjcssjc bean = BeanTransitUtil.trash2Bean(trash);
                dtsjCsglCsjcssjcMapper.insertSelective(bean);
            }
        });
    }
}

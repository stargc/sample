package com.ehl.tsq.data.business.service.ZHCG.toilets;

import com.alibaba.fastjson.JSON;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGToiletsMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.DtsjCsglCsjcssjc;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGToilets;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGToiletsExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/28 10:28
 */
@Service
@Slf4j
public class ToiletService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZHCGToiletsMapper toiletsMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;
    @Value("${ZHCG.toilets_page}")
    private String toiletsPageUrl;

    public void queryToiletInfo(){
        ZHCGResp<List<Map<String, String>>> resp =
                restTemplate.getForObject(toiletsPageUrl + "?start=1&limit=200", ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取环卫车基础信息 接口返回内容为空");
            return;
        }
        log.info("获取公厕条数：" + resp.getTotalCount());
        List<Map<String, String>> toiletList = resp.getData();
        toiletList.stream().forEach(map -> {
            ZHCGToilets toilet = JSON.parseObject(JSON.toJSONString(map), ZHCGToilets.class);

            ZHCGToiletsExample example = new ZHCGToiletsExample();
            example.createCriteria().andToiletIdEqualTo(toilet.getToiletId());
            List<ZHCGToilets> exitList = toiletsMapper.selectByExample(example);
            if (!exitList.isEmpty()){
                if ((toilet.getSensorIdMan() != null && !toilet.getSensorIdMan().equals(exitList.get(0).getSensorIdMan()))
                        ||(toilet.getSensorIdWoman() != null && !toilet.getSensorIdWoman().equals(exitList.get(0).getSensorIdWoman()))){
                    toilet.setUpdateTime(new Date());
                    toiletsMapper.updateByExampleSelective(toilet,example);
                }
                log.info("调用 获取公厕基础信息(" + toilet.getToiletId() + ")无变化");
            } else {
                toilet.setCreateTime(new Date());
                toiletsMapper.insertSelective(toilet);
                DtsjCsglCsjcssjc bean = BeanTransitUtil.toilet2Bean(toilet);
                dtsjCsglCsjcssjcMapper.insertSelective(bean);
            }
        });
    }

}

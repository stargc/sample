package com.ehl.tsq.data.business.service.ZHCG.station;

import com.alibaba.fastjson.JSON;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGStationsMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.DtsjCsglCsjcssjc;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGStations;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGStationsExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/28 15:19
 */
@Service
@Slf4j
public class StationsService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZHCGStationsMapper stationsMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;

    @Value("${ZHCG.stations_page}")
    private String stationsPageUrl;

    public void queryStationInfo(){
        ZHCGResp<List<Map<String, String>>> resp =
                restTemplate.getForObject(stationsPageUrl + "?start=1&limit=200", ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取垃圾中转站基础信息 接口返回内容为空");
            return;
        }
        log.info("获取垃圾中转站条数：" + resp.getTotalCount());
        List<Map<String, String>> stationList = resp.getData();
        stationList.stream().forEach(map -> {
            ZHCGStations station = JSON.parseObject(JSON.toJSONString(map), ZHCGStations.class);

            ZHCGStationsExample example = new ZHCGStationsExample();
            example.createCriteria().andStationIdEqualTo(station.getStationId());
            List<ZHCGStations> exitList = stationsMapper.selectByExample(example);
            if (!exitList.isEmpty()){
                if (!exitList.get(0).getSensorId().equals(station.getSensorId())){
                    station.setUpdateTime(new Date());
                    stationsMapper.updateByExampleSelective(station,example);
                }
                log.info("调用 获取中转站基础信息(" + station.getStationId() + ")无变化");
            } else {
                station.setCreateTime(new Date());
                stationsMapper.insertSelective(station);
                DtsjCsglCsjcssjc bean = BeanTransitUtil.station2Bean(station);
                dtsjCsglCsjcssjcMapper.insertSelective(bean);
            }
        });
    }
}

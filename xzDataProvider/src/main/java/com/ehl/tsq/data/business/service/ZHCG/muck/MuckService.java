package com.ehl.tsq.data.business.service.ZHCG.muck;

import com.alibaba.fastjson.JSONObject;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.*;
import com.ehl.tsq.data.infrastructure.persistence.po.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author created by guanchen on 2019/12/28 15:23
 */
@Service
@Slf4j
public class MuckService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZHCGMuckCarMapper carMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;
    @Autowired
    private ZHCGMuckCarTrackMapper trackMapper;

    @Value("${ZHCG.muck_tree}")
    private String muckTreeUrl;
    @Value("${ZHCG.muck_track}")
    private String muckTrackUrl;

    public void queryMuckCarInfo() {
        ZHCGResp<List<Map<String, String>>> resp =
                restTemplate.getForObject(muckTreeUrl + "?start=1&limit=200", ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取环卫车基础信息 接口返回内容为空");
            return;
        }
        log.info("获取渣土车辆条数：" + resp.getTotalCount());
        resp.getData().stream().forEach(map -> {
            MuckInfoResp muckInfo = JSONObject.parseObject(JSONObject.toJSONString(map), MuckInfoResp.class);
            saveMuck(muckInfo);

        });
    }

    private void saveMuck(MuckInfoResp muckInfo) {
        ZHCGMuckCar car = muckInfo.bean2Car();
        ZHCGMuckCarExample exitExample = new ZHCGMuckCarExample();
        exitExample.createCriteria().andCarIdEqualTo(muckInfo.getValue());
        if (carMapper.selectByExample(exitExample).isEmpty()) {
            car.setCreateTime(new Date());
            carMapper.insertSelective(car);
            if (0 == muckInfo.getIsParent()) {
                DtsjCsglCsjcssjc bean = BeanTransitUtil.muckCat2Bean(car);
                dtsjCsglCsjcssjcMapper.insertSelective(bean);
            }

        }
        muckInfo.getChildren().stream().forEach(muckInfoResp -> {
            saveMuck(muckInfoResp);
        });
    }

    public void queryMuckCarTrack() {
        ZHCGMuckCarExample example = new ZHCGMuckCarExample();
        example.createCriteria().andVehicleStateEqualTo(1);//查找状态为 在线车辆
        List<ZHCGMuckCar> carList = carMapper.selectByExample(example);

        long now = System.currentTimeMillis();
        long startTime = now  - 24 * 60 * 60 * 1000;
        carList.stream().forEach(car -> {
            StringBuilder url = new StringBuilder(muckTrackUrl).append(car.getName())
                    .append("?startTime=").append(startTime)
                    .append("&endTime=").append(now);
            ZHCGResp<List<List<Map<String, String>>>> resp =
                    restTemplate.getForObject(url.toString(), ZHCGResp.class);
            if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
                log.error("访问 获取环卫车历史轨迹 接口返回内容为空");
                return;
            }
            List<List<Map<String, String>>> trackList = resp.getData();
            DtsjCsglCsjcssjcExample dtExample = new DtsjCsglCsjcssjcExample();
            dtExample.createCriteria().andTypeCodeEqualTo("ZTC").andDeviceIdEqualTo(car.getId());
            DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
            if (trackList.isEmpty()) {
                //没有轨迹信息，保存线数据为0
                bean.setGeometry("((0,0),(0,0))");
                bean.setGeometry("线");
                dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);
            }

            StringBuilder trackSB = new StringBuilder("(");
            trackList.get(0).stream().forEach(map -> {
                ZHCGMuckCarTrack track = JSONObject.parseObject(
                        JSONObject.toJSONString(map), ZHCGMuckCarTrack.class);
                track.setCarId(car.getCarId());
                trackMapper.insertSelective(track);

                trackSB.append("(").append(track.getLongitude()).append(",")
                        .append(track.getLatitude()).append(")").append(",");
            });

            trackSB.substring(0, trackSB.length() - 1);
            bean.setGeometry(trackSB.append(")").toString());
            bean.setGeometry("线");
            bean.setUpdateTime(new Date());
            bean.setStarttime(new Date(startTime));
            bean.setEndtime(new Date(now));
            dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);
        });
    }
}

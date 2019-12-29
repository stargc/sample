package com.ehl.tsq.data.business.service.ZHCG.vehicles;

import com.alibaba.fastjson.JSONObject;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
import com.ehl.tsq.data.business.service.ZHCG.vo.DeviceTypeCodeEnum;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGEnvironmentalCarMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGEnvironmentalCarTrackMapper;
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
 * @author created by guanchen on 2019/12/28 10:28
 */
@Service
@Slf4j
public class VehicleService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ZHCGEnvironmentalCarMapper carMapper;
    @Autowired
    private DtsjCsglCsjcssjcMapper dtsjCsglCsjcssjcMapper;
    @Autowired
    private ZHCGEnvironmentalCarTrackMapper trackMapper;

    @Value("${ZHCG.vehicles_page}")
    private String vehiclesPageUrl;

    @Value("${ZHCG.vehicles_track}")
    private String vehiclesTrackUrl;

    public void queryVehicleInfo() {
        ZHCGResp<List<Map<String, String>>> resp =
                restTemplate.getForObject(vehiclesPageUrl + "?start=1&limit=51", ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取环卫车基础信息 接口返回内容为空");
            return;
        }
        log.info("获取环卫车辆条数：" + resp.getTotalCount());
        List<Map<String, String>> carList = resp.getData();
        carList.stream().forEach(map -> {
            ZHCGEnvironmentalCar car = JSONObject.parseObject(JSONObject.toJSONString(map), ZHCGEnvironmentalCar.class);

            ZHCGEnvironmentalCarExample example = new ZHCGEnvironmentalCarExample();
            example.createCriteria().andCarIdEqualTo(car.getCarId());
            List<ZHCGEnvironmentalCar> existCarList = carMapper.selectByExample(example);
            if (!existCarList.isEmpty()) {
                if (!existCarList.get(0).getDriverName().equals(car.getDriverName())
                        || !existCarList.get(0).getTelephone().equals(car.getTelephone())
                        || !existCarList.get(0).getEnclosureUrl().equals(car.getEnclosureUrl())
                        || !existCarList.get(0).getVehicleState().equals(car.getVehicleState())) {
                    car.setUpdateTime(new Date());
                    carMapper.updateByExampleSelective(car, example);
                }
                log.info("访问 获取环卫车基础信息<" + car.getCarId() + ">数据无变化");
            } else {
                car.setCreateTime(new Date());
                carMapper.insertSelective(car);
                DtsjCsglCsjcssjc bean = BeanTransitUtil.cat2Bean(car);
                dtsjCsglCsjcssjcMapper.insertSelective(bean);
            }
        });
    }

    public void queryVehicleTrack() {
        ZHCGEnvironmentalCarExample example = new ZHCGEnvironmentalCarExample();
        example.createCriteria();//查找状态为 在线车辆
        List<ZHCGEnvironmentalCar> carList = carMapper.selectByExample(example);

        long now = System.currentTimeMillis();
        long startTime = now - 24 * 60 * 60 * 1000;
        carList.stream().forEach(car -> {
            DtsjCsglCsjcssjcExample dtExample = new DtsjCsglCsjcssjcExample();
            dtExample.createCriteria().andTypeCodeEqualTo(DeviceTypeCodeEnum.HWCL.getCode()).andDeviceIdEqualTo(car.getId());
            DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();

            StringBuilder url = new StringBuilder(vehiclesTrackUrl).append(car.getCarId())
                    .append("?startTime=").append(startTime)
                    .append("&endTime=").append(now);
            ZHCGResp<List<List<Map<String, String>>>> resp =
                    restTemplate.getForObject(url.toString(), ZHCGResp.class);
            if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
                log.error("访问 获取环卫车历史轨迹 接口返回内容为空");
                bean.setGeometry("((0,0),(0,0))");
                dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);
                return;
            }
            List<List<Map<String, String>>> trackList = resp.getData();

            StringBuilder trackSB = new StringBuilder("[");
            trackList.get(0).stream().forEach(map -> {
                ZHCGEnvironmentalCarTrack track = JSONObject.parseObject(
                        JSONObject.toJSONString(map), ZHCGEnvironmentalCarTrack.class);
                track.setCarId(car.getCarId());

                ZHCGEnvironmentalCarTrackExample trackExample = new ZHCGEnvironmentalCarTrackExample();
                trackExample.createCriteria().andTrackIdEqualTo(track.getTrackId());
                if (trackMapper.selectByExample(trackExample).isEmpty()) {
                    trackMapper.insertSelective(track);
                }
                trackSB.append("(").append(track.getLongitude()).append(",")
                        .append(track.getLatitude()).append(")").append(",");
            });
            bean.setGeometry(trackSB.substring(0, trackSB.length() - 1) + "]");
            bean.setUpdateTime(new Date());
            bean.setStarttime(new Date(startTime));
            bean.setStarttime(new Date(now));
            dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);
        });
    }
}

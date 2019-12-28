package com.ehl.tsq.data.business.service.ZHCG.vehicles;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
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

import java.util.*;

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
        Map<String, String> parm = new HashMap<>();
        ZHCGResp<List<Map<String, String>>> resp =
                restTemplate.getForObject(vehiclesPageUrl + "?start=1&limit=51", ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取环卫车基础信息 接口返回内容为空");
            return;
        }
        List<Map<String, String>> carList = resp.getData();
        carList.stream().forEach(map -> {
            ZHCGEnvironmentalCar car = JSONObject.parseObject(JSONObject.toJSONString(map), ZHCGEnvironmentalCar.class);
            car.setCarId(car.getId());
            car.setId(null);

            ZHCGEnvironmentalCarExample example = new ZHCGEnvironmentalCarExample();
            example.createCriteria().andCarIdEqualTo(car.getCarId());
            List<ZHCGEnvironmentalCar> existCarList = carMapper.selectByExample(example);
            if (!existCarList.isEmpty()) {
                if (!existCarList.get(0).getDriverName().equals(car.getDriverName())
                        || !existCarList.get(0).getTelephone().equals(car.getTelephone())
                        || !existCarList.get(0).getEnclosureUrl().equals(car.getEnclosureUrl())
                        || !existCarList.get(0).getVehicleState().equals(car.getVehicleState())) {
                    car.setUpdateTime(new Date());
                    carMapper.updateByExample(car, example);
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

        //TODO:
        example.createCriteria().andVehicleStateEqualTo(1);//查找状态为 在线车辆
        List<ZHCGEnvironmentalCar> carList = carMapper.selectByExample(example);

        Map<String, String> parm = new HashMap<>();
        long now = System.currentTimeMillis();
        //TODO:
        parm.put("startTime", String.valueOf(now - 30 * 60 * 1000));//默认搜索版小数数据
        parm.put("endTime", String.valueOf(now));
        carList.stream().forEach(car -> {
            ZHCGResp<List<List<Map<String, String>>>> resp =
                    restTemplate.getForObject(vehiclesTrackUrl + car.getCarId(), ZHCGResp.class, parm);
            if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
                log.error("访问 获取环卫车历史轨迹 接口返回内容为空");
                return;
            }
            List<List<Map<String, String>>> trackList = resp.getData();
            StringBuilder trackSB = new StringBuilder("(");
            trackList.get(0).stream().forEach(map -> {
                map.put("trackId", map.get("id"));
                map.put("id", null);
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
            trackSB.substring(0, trackSB.length() - 1);
            DtsjCsglCsjcssjcExample dtExample = new DtsjCsglCsjcssjcExample();
            dtExample.createCriteria().andTypeCodeEqualTo("HWCL").andDeviceIdEqualTo(car.getId());
            DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();
            bean.setGeometry(trackSB.append(")").toString());
            dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);

        });
    }
}

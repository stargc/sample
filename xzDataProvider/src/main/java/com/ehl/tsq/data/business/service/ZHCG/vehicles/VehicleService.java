package com.ehl.tsq.data.business.service.ZHCG.vehicles;

import com.alibaba.fastjson.JSON;
import com.ehl.tsq.data.business.service.ZHCG.BeanTransitUtil;
import com.ehl.tsq.data.business.service.ZHCG.vo.DeviceTypeCodeEnum;
import com.ehl.tsq.data.business.service.ZHCG.vo.ZHCGResp;
import com.ehl.tsq.data.infrastructure.persistence.mapper.DtsjCsglCsjcssjcMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGEnvironmentalCarMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.ZHCGEnvironmentalCarTrackMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

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
            ZHCGEnvironmentalCar car = JSON.parseObject(JSON.toJSONString(map), ZHCGEnvironmentalCar.class);

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

    @Autowired
    private Executor threadPoolExcutor;

    public void queryVehicleTrack() {
        ZHCGEnvironmentalCarExample example = new ZHCGEnvironmentalCarExample();
        example.createCriteria();
        List<ZHCGEnvironmentalCar> carList = carMapper.selectByExample(example);

        long now = System.currentTimeMillis();
        long startTime = now - 24 * 60 * 60 * 1000;
        CountDownLatch countDownLatch = new CountDownLatch(carList.size());
        carList.stream().forEach(car -> {
            threadPoolExcutor.execute(new Runnable() {
                @Override
                public void run() {
                    calculateTrack(car,startTime,now);
                    countDownLatch.countDown();
                }
            });
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            Thread.currentThread().interrupt();
        }
    }

    private void calculateTrack(ZHCGEnvironmentalCar car,long startTime,long endTime){
        DtsjCsglCsjcssjcExample dtExample = new DtsjCsglCsjcssjcExample();
        dtExample.createCriteria().andTypeCodeEqualTo(DeviceTypeCodeEnum.HWCL.getCode()).andDeviceIdEqualTo(car.getId());
        DtsjCsglCsjcssjc bean = new DtsjCsglCsjcssjc();

        StringBuilder url = new StringBuilder(vehiclesTrackUrl).append(car.getCarId())
                .append("?startTime=").append(startTime)
                .append("&endTime=").append(endTime);
        ZHCGResp<List<List<Map<String, String>>>> resp =
                restTemplate.getForObject(url.toString(), ZHCGResp.class);
        if (resp == null || !"true".equals(resp.getSuccess()) || resp.getData().isEmpty()) {
            log.error("访问 获取环卫车历史轨迹 接口返回内容为空");
            bean.setGeometry("[[0,0],[0,0]]");
            bean.setUpdateTime(new Date());
            dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);
            return;
        }
        List<List<Map<String, String>>> trackList = resp.getData();

        log.info(String.format("环保车辆%s获取轨迹信息%d条",car.getId(),trackList.get(0).size()));
        StringBuilder trackSB = new StringBuilder("[");
        for (int i = 0; i < trackList.get(0).size(); i++) {
            ZHCGEnvironmentalCarTrack track = JSON.parseObject(
                    JSON.toJSONString(trackList.get(0).get(i)), ZHCGEnvironmentalCarTrack.class);
            track.setCarId(car.getCarId());

            ZHCGEnvironmentalCarTrackExample trackExample = new ZHCGEnvironmentalCarTrackExample();
            trackExample.createCriteria().andTrackIdEqualTo(track.getTrackId());
            if (trackMapper.selectByExample(trackExample).isEmpty()) {
                trackMapper.insertSelective(track);
            }
            trackSB.append("[").append(track.getLongitude()).append(",")
                    .append(track.getLatitude()).append("]").append(",");
            if (trackSB.length() > Math.pow(2,15)){
                //当数据超过 text 存储值后，强制退出
                break;
            }
        }
        bean.setGeometry(trackSB.substring(0, trackSB.length() - 1) + "]");
        bean.setUpdateTime(new Date());
        bean.setStarttime(new Date(startTime));
        bean.setEndtime(new Date(endTime));
        dtsjCsglCsjcssjcMapper.updateByExampleSelective(bean, dtExample);
        log.info(String.format("环保车辆%s处理轨迹信息%d条-完毕",car.getId(),trackList.get(0).size()));
    }
}

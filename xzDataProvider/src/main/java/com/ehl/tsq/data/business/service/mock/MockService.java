package com.ehl.tsq.data.business.service.mock;

import com.ehl.tsq.data.business.service.statCityManager.constant.BaseStatisticsEnum;
import com.ehl.tsq.data.infrastructure.persistence.mapper.BaseStatisticsMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatistics;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatisticsExample;
import com.ehl.tsq.data.infrastructure.persistence.po.CsglDtsjJcyjSjxxExample;
import com.ehl.tsq.data.infrastructure.util.EHLDateUtil;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author created by guanchen on 2019/12/24 10:22
 */
@Service
public class MockService {

    @Autowired
    private BaseStatisticsMapper baseStatisticsMapper;

    public void breakDevice(Date date){
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        addSHNum(now,BaseStatisticsEnum.CSSSSHLD,20,30);
        addSHNum(now,BaseStatisticsEnum.CSSSSHLJT,3,7);
        addSHNum(now,BaseStatisticsEnum.CSSSSHSXT,5,9);
    }
    private void addSHNum(Calendar now,BaseStatisticsEnum statistics,int minValue,int maxValue){
        BaseStatisticsExample deleteExample = new BaseStatisticsExample();
        deleteExample.createCriteria().andNameEqualTo(statistics.getName());
        baseStatisticsMapper.deleteByExample(deleteExample);
        for (int i = 0; i < 12; i++) {
            Calendar month = Calendar.getInstance();
            month.setTime(now.getTime());
            month.set(Calendar.MONTH,now.get(Calendar.MONTH) - i);
            Date monthStart = EHLDateUtil.getMonthStart(month.getTime());
            Date monthEnd = EHLDateUtil.getMonthEnd(month.getTime());

            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(RandomUtils.nextInt(minValue,maxValue)));
            baseStatistics.setDate(monthStart);
            baseStatistics.setDes(statistics.getMsg());
            baseStatistics.setIsTrue("TRUE");
            baseStatistics.setName(statistics.getName());
            baseStatistics.setUnit(statistics.getUnit());
            baseStatisticsMapper.insertSelective(baseStatistics);
        }
    }
}

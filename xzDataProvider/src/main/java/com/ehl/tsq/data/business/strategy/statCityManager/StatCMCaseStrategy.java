package com.ehl.tsq.data.business.strategy.statCityManager;

import com.ehl.tsq.data.business.strategy.cityManager.BaseStatisticsEnum;
import com.ehl.tsq.data.infrastructure.persistence.mapper.BaseStatisticsMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.CsglDtsjJcyjSjxxMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatistics;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatisticsExample;
import com.ehl.tsq.data.infrastructure.persistence.po.CsglDtsjJcyjSjxxExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author created by guanchen on 2019/12/20 15:40
 */
@Component
@Slf4j
public class StatCMCaseStrategy {

    @Autowired
    private CsglDtsjJcyjSjxxMapper csglDtsjJcyjSjxxMapper;

    @Autowired
    private BaseStatisticsMapper baseStatisticsMapper;

    public void statCase(){
        statStatusNum();
        statTypeNum();
    }

    private void statStatusNum(){
        CsglDtsjJcyjSjxxExample endStausExample = new CsglDtsjJcyjSjxxExample();
        endStausExample.createCriteria().andStatusEqualTo("DONE");
        int endStatusNum = csglDtsjJcyjSjxxMapper.countByExample(endStausExample);

        CsglDtsjJcyjSjxxExample doingStausExample = new CsglDtsjJcyjSjxxExample();
        doingStausExample.createCriteria().andStatusEqualTo("DOING");
        int doingStatusNum = csglDtsjJcyjSjxxMapper.countByExample(doingStausExample);

        CsglDtsjJcyjSjxxExample acceptStausExample = new CsglDtsjJcyjSjxxExample();
        acceptStausExample.createCriteria().andStatusEqualTo("ACCEPT");
        int acceptStatusNum = csglDtsjJcyjSjxxMapper.countByExample(acceptStausExample);

        int allStatusNum = endStatusNum + doingStatusNum + acceptStatusNum;
    }

    private void statTypeNum(){
        Calendar now = Calendar.getInstance();
        Calendar yearStart = Calendar.getInstance();
        yearStart.clear();
        yearStart.set(Calendar.YEAR,now.get(Calendar.YEAR));
        Calendar yearEnd = Calendar.getInstance();
        yearEnd.clear();
        yearEnd.set(Calendar.YEAR, now.get(Calendar.YEAR) +1 );

        List<StatCMCaseResultVo> resultVoList = csglDtsjJcyjSjxxMapper.selectGroupByType(yearStart.getTime(),yearEnd.getTime());

    }

    /***
     * 按所属街道 统计当月 城管案件数量
     */
    public void statStreetNumMonth(){
        Calendar now = Calendar.getInstance();
        Calendar monthStart = Calendar.getInstance();
        monthStart.clear();
        monthStart.set(Calendar.YEAR, now.get(Calendar.YEAR));
        monthStart.set(Calendar.MONTH,now.get(Calendar.MONTH));
        Calendar monthEnd = Calendar.getInstance();
        monthEnd.clear();
        monthEnd.set(Calendar.YEAR, now.get(Calendar.YEAR));
        monthEnd.set(Calendar.MONTH, now.get(Calendar.MONTH) +1 );
        updateOrAddStreetCauseNum(monthStart,monthEnd,now.getTime());

    }
    public void statStreetNumYear(int year){
        for (int i = 0; i < 12; i++) {
            Calendar monthStart = Calendar.getInstance();
            monthStart.clear();
            monthStart.set(Calendar.YEAR, year);
            monthStart.set(Calendar.MONTH,i);
            Calendar monthEnd = Calendar.getInstance();
            monthEnd.clear();
            monthEnd.set(Calendar.YEAR, year);
            monthEnd.set(Calendar.MONTH, i +1 );
            updateOrAddStreetCauseNum(monthStart,monthEnd,monthStart.getTime());
        }
    }
    private void updateOrAddStreetCauseNum(Calendar monthStart,Calendar monthEnd,Date updateTime){
        List<StatCMCaseResultVo> resultVoList = csglDtsjJcyjSjxxMapper.selectGroupByStreet
                (monthStart.getTime(),monthEnd.getTime());
        resultVoList.stream().forEach(vo ->{
            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(vo.getCount()));
            baseStatistics.setDate(updateTime);
            BaseStatisticsExample example = new BaseStatisticsExample();
            example.createCriteria().andNameEqualTo(BaseStatisticsEnum.CSAJGFD.getName())
                    .andDateBetween(monthStart.getTime(),monthEnd.getTime())
                    .andRegionEqualTo(vo.getType());
            List<BaseStatistics> result = baseStatisticsMapper.selectByExample(example);
            if (result.isEmpty()){
                baseStatistics.setName(BaseStatisticsEnum.CSAJGFD.getName());
                baseStatistics.setDes(BaseStatisticsEnum.CSAJGFD.getMsg());
                baseStatistics.setRegion(vo.getType());
                baseStatistics.setUnit(BaseStatisticsEnum.CSAJGFD.getUnit());
                baseStatistics.setIsTrue("TRUE");
                baseStatisticsMapper.insertSelective(baseStatistics);
            } else {
                baseStatisticsMapper.updateByExampleSelective(baseStatistics, example);
            }
        });
    }

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();
        Calendar monthStart = Calendar.getInstance();
        monthStart.clear();
        monthStart.set(Calendar.YEAR, now.get(Calendar.YEAR));
        monthStart.set(Calendar.MONTH,now.get(Calendar.MONTH));
        Calendar monthEnd = Calendar.getInstance();
        monthEnd.clear();
        monthEnd.set(Calendar.YEAR, now.get(Calendar.YEAR));
        monthEnd.set(Calendar.MONTH, now.get(Calendar.MONTH) +1 );

        System.out.println(monthStart.getTime().toLocaleString());
        System.out.println(monthEnd.getTime().toLocaleString());

        monthStart.set(Calendar.MONTH,now.get(Calendar.MONTH) -1);
        monthEnd.set(Calendar.YEAR, now.get(Calendar.YEAR));
        monthEnd.set(Calendar.MONTH, now.get(Calendar.MONTH));

        System.out.println(monthStart.getTime().toLocaleString());
        System.out.println(monthEnd.getTime().toLocaleString());
    }
}

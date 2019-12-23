package com.ehl.tsq.data.business.service.statCityManager;

import com.ehl.tsq.data.business.service.statCityManager.constant.BaseStatisticsEnum;
import com.ehl.tsq.data.business.service.statCityManager.constant.BaseStatisticsEnumTool;
import com.ehl.tsq.data.infrastructure.persistence.mapper.BaseStatisticsMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.CsglDtsjJcyjSjxxMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatistics;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatisticsExample;
import com.ehl.tsq.data.infrastructure.persistence.po.CsglDtsjJcyjSjxxExample;
import com.ehl.tsq.data.infrastructure.util.EHLDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author created by guanchen on 2019/12/20 15:40
 */
@Component
@Slf4j
public class StatCMCaseService {

    @Autowired
    private CsglDtsjJcyjSjxxMapper csglDtsjJcyjSjxxMapper;

    @Autowired
    private BaseStatisticsMapper baseStatisticsMapper;

    /***
     * 更新当日案件进度数量
     */
    public void statStatusNum(Date date){
        if (date == null){
            date = new Date();
        }
        Date dayStart = EHLDateUtil.getDayStart(date);
        Date dayEnd = EHLDateUtil.getDayEnd(date);

        int endStatusNum = updateTodayStatueCause(BaseStatisticsEnumTool.CSGL_AJCLQK_DONE,dayStart,dayEnd);
        int doingStatusNum = updateTodayStatueCause(BaseStatisticsEnumTool.CSGL_AJCLQK_DOING,dayStart,dayEnd);
        int acceptStatusNum = updateTodayStatueCause(BaseStatisticsEnumTool.CSGL_AJCLQK_ACCEPT,dayStart,dayEnd);
        int allStatusNum = endStatusNum + doingStatusNum + acceptStatusNum;

        BaseStatisticsExample allStatusExample = new BaseStatisticsExample();
        allStatusExample.createCriteria().andNameEqualTo(BaseStatisticsEnum.JRSLL.getName());
        BaseStatistics allStat = new BaseStatistics();
        allStat.setValue(Double.valueOf(allStatusNum));
        allStat.setDate(dayStart);
        baseStatisticsMapper.updateByExampleSelective(allStat,allStatusExample);

    }

    private int updateTodayStatueCause(String status,Date dayStart,Date dayEnd){
        CsglDtsjJcyjSjxxExample causeExample = new CsglDtsjJcyjSjxxExample();
        causeExample.createCriteria().andStatusEqualTo(status)
                .andWarningtimeBetween(dayStart,dayEnd);
        int num = csglDtsjJcyjSjxxMapper.countByExample(causeExample);
        BaseStatisticsExample statExample = new BaseStatisticsExample();
        statExample.createCriteria().andNameEqualTo(BaseStatisticsEnumTool.CSGLAJCLQKMap.get(status).getName());
        BaseStatistics statistics = new BaseStatistics();
        statistics.setValue(Double.valueOf(num));
        baseStatisticsMapper.updateByExampleSelective(statistics,statExample);
        return num;
    }

    /***
     * 安装类型 统计城管案件 TOP5
     */
    public void statTypeTop5Num(){
        Date yearStart = EHLDateUtil.getNowYearStart();
        Date yearEnd = EHLDateUtil.getNowYearEnd();
        List<StatCMCaseResultVo> resultVoList = csglDtsjJcyjSjxxMapper.selectGroupByType(yearStart,yearEnd);
        for (int i = 0; i < 5; i++) {
            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(resultVoList.get(i).getCount()));
            baseStatistics.setDate(yearStart);
            baseStatistics.setDes(resultVoList.get(i).getTypeDes());
            BaseStatisticsExample example = new BaseStatisticsExample();
            BaseStatisticsEnum statisticsEnum = BaseStatisticsEnumTool.CSGFAJTJByMap.get(i);
            if (statisticsEnum == null){
                continue;
            }
            example.createCriteria().andNameEqualTo(statisticsEnum.getName());
            baseStatisticsMapper.updateByExampleSelective(baseStatistics,example);
        }
    }

    /***
     * 按所属街道 统计当月 城管案件数量
     */
    public void statStreetNumMonth(){
        Date monthStart = EHLDateUtil.getNowMonthStart();
        Date monthEnd = EHLDateUtil.getNowMonthEnd();
        updateOrAddStreetCauseNum(monthStart,monthEnd,new Date());

    }
    public void statStreetNumYear(int year){
        for (int i = 0; i < 12; i++) {
            Date monthStart = EHLDateUtil.getMonthStart(year,i + 1);
            Date monthEnd = EHLDateUtil.getMonthEnd(year, i + 1);
            updateOrAddStreetCauseNum(monthStart,monthEnd,monthStart);
        }
    }
    private void updateOrAddStreetCauseNum(Date monthStart,Date monthEnd,Date updateTime){
        List<StatCMCaseResultVo> resultVoList = csglDtsjJcyjSjxxMapper.selectGroupByStreet
                (monthStart,monthEnd);
        resultVoList.stream().forEach(vo ->{
            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(vo.getCount()));
            baseStatistics.setDate(updateTime);
            BaseStatisticsExample example = new BaseStatisticsExample();
            example.createCriteria().andNameEqualTo(BaseStatisticsEnum.CSAJGFD.getName())
                    .andDateBetween(monthStart,monthEnd)
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

    /***
     * 上报案件分类
     */
    public void statTypeNum(int year,int month){
        Date startTime = EHLDateUtil.getNowMonthStart();
        Date endTime = EHLDateUtil.getNowMonthEnd();
        if (year != 0 && month != 0){
            startTime = EHLDateUtil.getMonthStart(year,month);
            endTime = EHLDateUtil.getMonthEnd(year,month);
        }
        List<StatCMCaseResultVo> resultVoList = csglDtsjJcyjSjxxMapper.selectGroupByType(startTime,endTime);

        CsglDtsjJcyjSjxxExample countExample = new CsglDtsjJcyjSjxxExample();
        countExample.createCriteria().andWarningtimeBetween(startTime,endTime);
        int count = csglDtsjJcyjSjxxMapper.countByExample(countExample);
        if (count <= 0){
            log.error("安装类型 统计城管案件: 总数量为0");
            return;
        }

        BaseStatisticsExample deleteExample = new BaseStatisticsExample();
        deleteExample.createCriteria().andNameEqualTo(BaseStatisticsEnum.AJSBFL.getName());
        baseStatisticsMapper.deleteByExample(deleteExample);

        resultVoList.stream().forEach(vo -> {
            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(vo.getCount()));
            baseStatistics.setDate(new Date());
            baseStatistics.setDes(vo.getTypeDes());
            baseStatistics.setIsTrue("TRUE");
            baseStatistics.setName(BaseStatisticsEnum.AJSBFL.getName());
            baseStatistics.setYearOnYear(Double.valueOf(vo.getCount())/count);
            baseStatisticsMapper.insertSelective(baseStatistics);
        });
    }

    /***
     * 统计当日上报实时动态
     */
    public void statCauseNumByDay(Date date){
        BaseStatisticsExample deleteExample = new BaseStatisticsExample();
        deleteExample.createCriteria().andNameEqualTo(BaseStatisticsEnum.RAJSBSSDT.getName());
        baseStatisticsMapper.deleteByExample(deleteExample);
        Calendar now = Calendar.getInstance();
        if (date != null){
            now.setTime(date);
        }
        for (int i = 0; i < 31; i++) {
            Calendar day = Calendar.getInstance();
            day.set(Calendar.HOUR_OF_DAY,0);
            day.set(Calendar.MINUTE,0);
            day.set(Calendar.SECOND,0);
            day.set(Calendar.DAY_OF_MONTH,now.get(Calendar.DAY_OF_MONTH) - i);

            Date dayStart = EHLDateUtil.getDayStart(day.getTime());
            Date dayEnd = EHLDateUtil.getDayEnd(day.getTime());
            CsglDtsjJcyjSjxxExample example = new CsglDtsjJcyjSjxxExample();
            example.createCriteria().andWarningtimeBetween(dayStart,dayEnd);
            int count = csglDtsjJcyjSjxxMapper.countByExample(example);

            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(count));
            baseStatistics.setDate(dayStart);
            baseStatistics.setDes(BaseStatisticsEnum.RAJSBSSDT.getMsg());
            baseStatistics.setIsTrue("TRUE");
            baseStatistics.setName(BaseStatisticsEnum.RAJSBSSDT.getName());
            baseStatistics.setUnit(BaseStatisticsEnum.RAJSBSSDT.getUnit());
            baseStatisticsMapper.insertSelective(baseStatistics);
        }
    }

    /***
     * 统计当月上报实时动态
     */
    public void statCauseNumByMonth(Date date){
        Calendar now = Calendar.getInstance();
        if (date != null) {
            now.setTime(date);
        }
        BaseStatisticsExample deleteExample = new BaseStatisticsExample();
        deleteExample.createCriteria().andNameEqualTo(BaseStatisticsEnum.YAJSBSSDT.getName());
        baseStatisticsMapper.deleteByExample(deleteExample);
        for (int i = 0; i < 12; i++) {
            Calendar month = Calendar.getInstance();
            month.setTime(now.getTime());
            month.set(Calendar.MONTH,now.get(Calendar.MONTH) - i);
            Date monthStart = EHLDateUtil.getMonthStart(month.getTime());
            Date monthEnd = EHLDateUtil.getMonthEnd(month.getTime());

            CsglDtsjJcyjSjxxExample example = new CsglDtsjJcyjSjxxExample();
            example.createCriteria().andWarningtimeBetween(monthStart,monthEnd);
            int count = csglDtsjJcyjSjxxMapper.countByExample(example);

            BaseStatistics baseStatistics = new BaseStatistics();
            baseStatistics.setValue(Double.valueOf(count));
            baseStatistics.setDate(monthStart);
            baseStatistics.setDes(BaseStatisticsEnum.YAJSBSSDT.getMsg());
            baseStatistics.setIsTrue("TRUE");
            baseStatistics.setName(BaseStatisticsEnum.YAJSBSSDT.getName());
            baseStatistics.setUnit(BaseStatisticsEnum.YAJSBSSDT.getUnit());
            baseStatisticsMapper.insertSelective(baseStatistics);
        }
    }

}

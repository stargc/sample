package com.ehl.tsq.data.business.strategy.statCityManager;

import com.ehl.tsq.data.business.strategy.statCityManager.constant.BaseStatisticsEnum;
import com.ehl.tsq.data.business.strategy.statCityManager.constant.BaseStatisticsEnumTool;
import com.ehl.tsq.data.infrastructure.persistence.mapper.BaseStatisticsMapper;
import com.ehl.tsq.data.infrastructure.persistence.mapper.CsglDtsjJcyjSjxxMapper;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatistics;
import com.ehl.tsq.data.infrastructure.persistence.po.BaseStatisticsExample;
import com.ehl.tsq.data.infrastructure.persistence.po.CsglDtsjJcyjSjxxExample;
import com.ehl.tsq.data.infrastructure.util.EHLDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        statStatusNum(null);
        statTypeNum();
    }

    /***
     * 更新当日 案件进度数量
     */
    public void statStatusNum(Date date){
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
     * 安装类型 统计城管案件
     */
    public void statTypeNum(){
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
}

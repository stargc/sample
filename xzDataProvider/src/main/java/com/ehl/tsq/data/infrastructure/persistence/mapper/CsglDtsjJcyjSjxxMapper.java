package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.business.service.statCityManager.StatCMCaseResultVo;
import com.ehl.tsq.data.infrastructure.persistence.po.CsglDtsjJcyjSjxx;
import com.ehl.tsq.data.infrastructure.persistence.po.CsglDtsjJcyjSjxxExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CsglDtsjJcyjSjxxMapper {
    int countByExample(CsglDtsjJcyjSjxxExample example);

    int deleteByExample(CsglDtsjJcyjSjxxExample example);

    int insert(CsglDtsjJcyjSjxx record);

    int insertSelective(CsglDtsjJcyjSjxx record);

    List<CsglDtsjJcyjSjxx> selectByExample(CsglDtsjJcyjSjxxExample example);

    int updateByExampleSelective(@Param("record") CsglDtsjJcyjSjxx record, @Param("example") CsglDtsjJcyjSjxxExample example);

    int updateByExample(@Param("record") CsglDtsjJcyjSjxx record, @Param("example") CsglDtsjJcyjSjxxExample example);

    List<StatCMCaseResultVo> selectGroupByType(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<StatCMCaseResultVo> selectGroupByStreet(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
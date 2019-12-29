package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrashWarning;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrashWarningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGTrashWarningMapper {
    int countByExample(ZHCGTrashWarningExample example);

    int deleteByExample(ZHCGTrashWarningExample example);

    int insert(ZHCGTrashWarning record);

    int insertSelective(ZHCGTrashWarning record);

    List<ZHCGTrashWarning> selectByExample(ZHCGTrashWarningExample example);

    int updateByExampleSelective(@Param("record") ZHCGTrashWarning record, @Param("example") ZHCGTrashWarningExample example);

    int updateByExample(@Param("record") ZHCGTrashWarning record, @Param("example") ZHCGTrashWarningExample example);
}
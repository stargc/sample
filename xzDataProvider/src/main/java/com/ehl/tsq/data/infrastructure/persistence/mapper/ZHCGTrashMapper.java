package com.ehl.tsq.data.infrastructure.persistence.mapper;

import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrash;
import com.ehl.tsq.data.infrastructure.persistence.po.ZHCGTrashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHCGTrashMapper {
    int countByExample(ZHCGTrashExample example);

    int deleteByExample(ZHCGTrashExample example);

    int insert(ZHCGTrash record);

    int insertSelective(ZHCGTrash record);

    List<ZHCGTrash> selectByExample(ZHCGTrashExample example);

    int updateByExampleSelective(@Param("record") ZHCGTrash record, @Param("example") ZHCGTrashExample example);

    int updateByExample(@Param("record") ZHCGTrash record, @Param("example") ZHCGTrashExample example);
}
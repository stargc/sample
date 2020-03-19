package com.ehualu.data.business.svnuser.dao;

import com.ehualu.data.business.svnuser.model.SvnUser;
import com.ehualu.data.business.svnuser.model.SvnUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SvnUserMapper {
    int countByExample(SvnUserExample example);

    int deleteByExample(SvnUserExample example);

    int insert(SvnUser record);

    int insertSelective(SvnUser record);

    List<SvnUser> selectByExample(SvnUserExample example);

    int updateByExampleSelective(@Param("record") SvnUser record, @Param("example") SvnUserExample example);

    int updateByExample(@Param("record") SvnUser record, @Param("example") SvnUserExample example);
}
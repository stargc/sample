package com.ehualu.data.business.repositories.dao;

import com.ehualu.data.business.repositories.model.RepositoriesConfig;
import com.ehualu.data.business.repositories.model.RepositoriesConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepositoriesConfigMapper {
    int countByExample(RepositoriesConfigExample example);

    int deleteByExample(RepositoriesConfigExample example);

    int insert(RepositoriesConfig record);

    int insertSelective(RepositoriesConfig record);

    List<RepositoriesConfig> selectByExample(RepositoriesConfigExample example);

    int updateByExampleSelective(@Param("record") RepositoriesConfig record, @Param("example") RepositoriesConfigExample example);

    int updateByExample(@Param("record") RepositoriesConfig record, @Param("example") RepositoriesConfigExample example);
}
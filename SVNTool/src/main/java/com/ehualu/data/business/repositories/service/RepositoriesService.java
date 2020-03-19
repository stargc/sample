package com.ehualu.data.business.repositories.service;

import com.ehualu.data.business.repositories.dao.RepositoriesConfigMapper;
import com.ehualu.data.business.repositories.model.RepositoriesConfig;
import com.ehualu.data.business.repositories.model.RepositoriesConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author created by guanchen on 2020/3/18 14:54
 */
@Service
public class RepositoriesService {

    @Autowired
    private RepositoriesConfigMapper repositoriesConfigMapper;


//    @Cacheable(value = "SVNCONFIG", key = "1")
    public RepositoriesConfig getRepConfig(){
        RepositoriesConfigExample example = new RepositoriesConfigExample();
        return repositoriesConfigMapper.selectByExample(example).get(0);

    }
}

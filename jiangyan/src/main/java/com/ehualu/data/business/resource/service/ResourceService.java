package com.ehualu.data.business.resource.service;

import com.ehualu.data.business.resource.dao.DictMapper;
import com.ehualu.data.business.resource.dao.FieldMapper;
import com.ehualu.data.business.resource.dao.TableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author created by guanchen on 2020/5/20 15:53
 */
@Service
@Slf4j
public class ResourceService {
    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private FieldMapper fieldMapper;
    @Autowired
    private DictMapper dictMapper;

}

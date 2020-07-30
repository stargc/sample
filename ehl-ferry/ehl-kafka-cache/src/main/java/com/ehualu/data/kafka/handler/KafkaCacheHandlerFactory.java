package com.ehualu.data.kafka.handler;

import com.ehualu.data.kafka.handler.impl.KafkaCacheDefaultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author created by guanchen on 2020/7/23 17:27
 */
@Component
public class KafkaCacheHandlerFactory {
    private static final Logger logger = LoggerFactory.getLogger(KafkaCacheHandlerFactory.class);

    private List<KafkaCacheHandler> handlerList = new ArrayList<>();

    public void setHandle(KafkaCacheHandler... handler){
        handlerList = Arrays.asList(handler);
    }
    public List<KafkaCacheHandler> getHandlers(){
        if (handlerList.isEmpty()){
            return Arrays.asList(new KafkaCacheDefaultHandler());
        }
        return handlerList;
    }
}

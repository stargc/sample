package com.ehualu.data.business.es;

import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@Slf4j
@RestController
public class ESController {

    @Autowired
    private ESService esService;

    @RequestMapping("/es/test")
    public Message<String> upload(@RequestParam String index,@RequestParam String id){
        if (!esService.exitHighIndex(index)){
            esService.createHighIndexWithShardNum(index);
        }
        return new MessageBuilder.Builder<String>().setStatus(Message.Code.OK).setData(esService.queryData(index,id)).builder();
    }

}

package com.ehualu.data.business.delivery.controller;

import com.ehualu.data.business.delivery.model.DeliveryReq;
import com.ehualu.data.business.delivery.model.DeliveryResp;
import com.ehualu.data.business.delivery.model.SearchReq;
import com.ehualu.data.business.delivery.model.SearchResp;
import com.ehualu.data.business.delivery.service.DeliveryService;
import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author created by guanchen on 2020/3/19 10:36
 */
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("add")
    public Message<DeliveryResp> doDelivery(@RequestBody @Valid DeliveryReq req){
        DeliveryResp resp = deliveryService.delivery(req);
        return new MessageBuilder.Builder<DeliveryResp>()
                .setStatus(Message.Code.OK)
                .setData(resp)
                .builder();
    }

    @GetMapping("delete")
    public Message deleteDelivery(){
        deliveryService.deleteOverdue();
        return new MessageBuilder.Builder<>()
                .setStatus(Message.Code.OK)
                .builder();
    }

    @PostMapping("_search")
    public Message<SearchResp> search(@RequestBody @Valid SearchReq req){
        SearchResp resp = deliveryService.search(req);
        return new MessageBuilder.Builder<SearchResp>()
                .setStatus(Message.Code.OK)
                .setData(resp)
                .builder();
    }
}

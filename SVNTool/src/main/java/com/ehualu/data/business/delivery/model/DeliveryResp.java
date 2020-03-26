package com.ehualu.data.business.delivery.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author created by guanchen on 2020/3/24 17:05
 */
@Data
public class DeliveryResp {

    private String svnUser;
    private String repositoryUrl;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date overdueDate;
}

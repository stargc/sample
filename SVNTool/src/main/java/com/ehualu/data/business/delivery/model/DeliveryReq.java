package com.ehualu.data.business.delivery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author created by guanchen on 2020/3/19 10:03
 */
@Data
public class DeliveryReq {

    private int productId;

    @NotBlank(message = "用户不能为空")
    private String svnUserids;

    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date overdueDate;
    @NotBlank(message = "项目code不能为空")
    private String projectCode;
    @NotBlank(message = "项目名称不能为空")
    private String projectName;
}

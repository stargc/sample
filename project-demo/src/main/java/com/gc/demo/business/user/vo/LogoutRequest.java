package com.gc.demo.business.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author created by guanchen on 2021/5/6 14:26
 */
@Data
public class LogoutRequest {
    @NotBlank(message = "用户名不能为空")
    private String userName;
}

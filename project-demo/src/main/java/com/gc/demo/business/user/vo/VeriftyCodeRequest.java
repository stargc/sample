package com.gc.demo.business.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author created by guanchen on 2021/5/6 17:21
 */
@Data
public class VeriftyCodeRequest {

    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "验证码不能为空")
    private String code;
}

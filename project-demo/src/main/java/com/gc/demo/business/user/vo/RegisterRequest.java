package com.gc.demo.business.user.vo;

import com.gc.demo.infrastructure.persistence.po.UserInfo;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author created by guanchen on 2021/5/6 14:41
 */
@Data
public class RegisterRequest {
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
    private String nickName;
    private String avatarUrl;
    private String realName;
    private String idCard;
    private String phoneNumber;
    private String wxAccount;
    private String qqAccount;
    private String mailAccount;

    public UserInfo tran2UserInfo(){
        UserInfo info = new UserInfo();
        info.setAvatarUrl(this.avatarUrl);
        info.setIdCard(this.idCard);
        info.setMailAccount(this.mailAccount);
        info.setNickName(this.nickName);
        info.setPassword(this.password);
        info.setPhoneNumber(this.phoneNumber);
        info.setQqAccount(this.qqAccount);
        info.setRealName(this.realName);
        info.setUserName(this.userName);
        info.setWxAccount(this.wxAccount);
        return info;
    }
}

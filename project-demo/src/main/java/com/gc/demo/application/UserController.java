package com.gc.demo.application;

import com.gc.demo.business.user.AvatarService;
import com.gc.demo.business.user.BaseService;
import com.gc.demo.business.user.vo.LoginRequest;
import com.gc.demo.business.user.vo.LogoutRequest;
import com.gc.demo.business.user.vo.RegisterRequest;
import com.gc.demo.infrastructure.model.BaseResponse;
import com.gc.demo.infrastructure.model.BaseResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author created by guanchen on 2021/5/6 14:04
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private BaseService baseService;
    @Autowired
    private AvatarService avatarService;

    @PostMapping("/login")
    public BaseResponse login(@RequestBody @Valid LoginRequest request){
        baseService.login(request);
        return new BaseResponseBuilder.Builder<>(true).builder();
    }

    @PostMapping("/logout")
    public BaseResponse logout(@RequestBody @Valid LogoutRequest request){
        log.info(request.getUserName() + " do logout!");
        return new BaseResponseBuilder.Builder<>(true).builder();
    }

    @PostMapping("/register")
    public BaseResponse register(@RequestBody @Valid RegisterRequest request){
        baseService.register(request);
        return new BaseResponseBuilder.Builder<>(true).builder();
    }

    @PostMapping("/uploadAvatar/{userId}")
    public BaseResponse uploadAvatar(@RequestParam("file") MultipartFile file,@PathVariable(value = "userId")int userId){
        avatarService.uploadAvatar(file,userId);
        return new BaseResponseBuilder.Builder<>(true).builder();
    }

    @GetMapping("/showAvatar/{name}")
    public void showAvatar(@PathVariable(value = "name") String name,HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        avatarService.showAvatar(name,response);
    }
}

package com.gc.demo.business.user;

import com.gc.demo.business.user.vo.VeriftyCodeRequest;
import com.gc.demo.infrastructure.exception.LogicErrorException;
import com.gc.demo.infrastructure.persistence.mapper.VerifyCodeMapper;
import com.gc.demo.infrastructure.persistence.po.VerifyCode;
import com.gc.demo.infrastructure.persistence.po.VerifyCodeExample;
import com.gc.demo.infrastructure.util.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author created by guanchen on 2021/5/6 17:10
 */
@Service
@Slf4j
public class ImageCodeService {
    @Autowired
    private VerifyCodeMapper verifyCodeMapper;

    public void getCodeImage(String userName,HttpServletResponse response) throws IOException {
        int w = 200, h = 80;
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        VerifyCode bean = new VerifyCode();
        bean.setUserName(userName);
        bean.setCode(verifyCode);
        bean.setType(0);
        verifyCodeMapper.insertSelective(bean);
    }

    public boolean checkImageCode(VeriftyCodeRequest request){
        VerifyCodeExample example = new VerifyCodeExample();
        example.createCriteria().andUserNameEqualTo(request.getUserName());
        example.setOrderByClause("create_time DESC");
        List<VerifyCode> codeList = verifyCodeMapper.selectByExample(example);
        if (codeList.isEmpty() || StringUtils.isBlank(codeList.get(0).getCode())){
            throw new LogicErrorException("请先获取图形验证码");
        }
        if (!request.getCode().toUpperCase().equals(codeList.get(0).getCode().toUpperCase())) {
            throw new LogicErrorException("验证码错误");
        }
        return true;
    }
}

package com.ehualu.data.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.AESUtil;
import com.ehualu.data.common.util.MessageBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@ConditionalOnProperty(name="spring.profiles.active", havingValue="pro")
@Component
@WebFilter(urlPatterns = "/svn/api/*")
@Slf4j
public class TokenFilter implements Filter {
    private static List<String> paseUrl = new ArrayList<>();

    static {
        paseUrl.add("/svn/api/user/_login");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String path = httpServletRequest.getRequestURI();

        if (paseUrl.contains(path) || !path.startsWith("/svn/api")) {
            chain.doFilter(request, response);
            return;
        }
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isBlank(token)){
            sendError(httpServletResponse,"token不存在");
            return;
        }

        String[] info = token.split("\\.");
        if (info.length != 3) {
            sendError(httpServletResponse,"token验证失败");
            return;
        }
        long overdueTime = 0;
        String userName = "";
        int userId = 0;
        try {
            userName = AESUtil.decrypt(info[0]);
            userId = Integer.valueOf(AESUtil.decrypt(info[1]));
            overdueTime = Long.valueOf(AESUtil.decrypt(info[2]));
        } catch (Exception e) {
            sendError(httpServletResponse,"token验证失败");
            return;
        }

        if (overdueTime < System.currentTimeMillis()) {
            sendError(httpServletResponse,"token已过期");
            return;
        }
        RequestHolder.setUserId(userId);

        chain.doFilter(request, response);
    }

    private void goToLogin(ServletRequest request, ServletResponse response) {
        try {
            ((HttpServletResponse)response).sendRedirect("/svn/page/login");
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    private void sendError(HttpServletResponse httpServletResponse, String errorMsg) throws IOException {
        Message<Void> responseMessage = new MessageBuilder.Builder<Void>().setErrorCode(Message.Code.ERROR)
                .setStatus(Message.Code.ERROR).setError(errorMsg).builder();
        {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(responseMessage));
            return;
        }

    }

}

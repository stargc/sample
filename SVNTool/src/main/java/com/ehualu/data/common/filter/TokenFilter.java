package com.ehualu.data.common.filter;

import com.ehualu.data.common.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component
@WebFilter(urlPatterns = "/svn/*")
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

        if (paseUrl.contains(path) || path.startsWith("/svn/page/")) {
            chain.doFilter(request, response);
            return;
        }
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isBlank(token)){
            goToLogin(request,response);
            return;
        }

        String[] info = token.split("\\.");
        if (info.length != 3) {
            goToLogin(request,response);
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
            goToLogin(request,response);
            return;
        }

        if (overdueTime < System.currentTimeMillis()) {
            goToLogin(request,response);
            return;
        }
        RequestHolder.setUserId(userId);

        chain.doFilter(request, response);
    }

    public void goToLogin(ServletRequest request, ServletResponse response) {
        try {
            ((HttpServletResponse)response).sendRedirect("/svn/page/login");
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

}

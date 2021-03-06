package com.ehl.tsq.data.infrastructure.logging;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
public class RestTemplateLogInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) {

        try {
            log.info("发送请求： URI={},Method={},Headers={},RequestBody={}", request.getURI(), request.getMethod(), request.getHeaders(), new String(body, StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.warn("打印restTemplate请求出错：{}", ExceptionUtils.getStackTrace(e));
        }
    }

    private void traceResponse(ClientHttpResponse response) {
        InputStream bodyInputStream = null;
        try {
            bodyInputStream = response.getBody();
        } catch (Exception e) {
            log.warn("获取restTemplate响应出错：{}", ExceptionUtils.getStackTrace(e));
            return;
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(bodyInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            StringBuilder inputStringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            if(inputStringBuilder.length() > 2048){
                inputStringBuilder = new StringBuilder("omit...");
            }
            log.info("收到响应：Status={}-{},Headers={},ResponseBody={}", response.getStatusCode(), response.getStatusText(), response.getHeaders(), inputStringBuilder.toString());
        } catch (IOException e) {
            log.warn("打印restTemplate响应出错：{}", ExceptionUtils.getStackTrace(e));
        }
    }
}

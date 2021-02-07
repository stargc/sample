package com.ehualu.data.business.es;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author created by guanchen on 2020/10/10 17:16
 */
@Configuration
@Slf4j
public class ESConfig {

    @SneakyThrows
    @Bean
    public RestHighLevelClient getRestHighLevelClient(){
        RestHighLevelClient restHighLevelClient = null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(ResourceUtils.getFile("/home/gc/fastDFS-sample-0.1.0/config/es.properties")));
        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
        }

        String esServerHost = properties.getProperty("EsServerHost");
        Integer ConnectTimeout = Integer.valueOf(properties.getProperty("ConnectTimeout"));
        Integer SocketTimeout = Integer.valueOf(properties.getProperty("SocketTimeout"));
        String isSecureMode = properties.getProperty("isSecureMode");
        String userPrincipal = properties.getProperty("userPrincipal");
        String schema = "http";


        if ("true".equals(isSecureMode)) {
            LoginUtil.login(userPrincipal,"/home/gc/fastDFS-sample-0.1.0/config/221.keytab",
                    "/home/gc/fastDFS-sample-0.1.0/config/221.krb5.conf");

            System.setProperty("sun.security.krb5.debug", "false");
            System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
            //add for ES security indication
            System.setProperty("es.security.indication", "true");
            schema = "https";
        }else {
            System.setProperty("es.security.indication", "false");
        }

        try {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(getHostArray(esServerHost,schema)).setRequestConfigCallback(
                            requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(ConnectTimeout).setSocketTimeout(SocketTimeout)
                    )
            );
        }catch (Exception e){
            log.error(ExceptionUtils.getStackTrace(e));
            if (restHighLevelClient != null) {
                restHighLevelClient.close();
            }
        }
        return restHighLevelClient;
    }

    /**
     * 定义elasticsearch集群adress
     * @param esServerHost
     * @return
     * @throws Exception
     */
    public static HttpHost[] getHostArray(String esServerHost, String schema) throws Exception {

        List<HttpHost> hosts = new ArrayList<>();
        String[] hostArray1 = esServerHost.split(",");

        for (String host:hostArray1){
            String[] ipPort = host.split(":");
            HttpHost hostNew = new HttpHost(ipPort[0],Integer.valueOf(ipPort[1]),schema);
            hosts.add(hostNew);
        }

        return hosts.toArray(new HttpHost[] {});
    }
}

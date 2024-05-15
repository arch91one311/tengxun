package com.arch.gateway;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * WebBff启动类
 * @author chenkun
 */
@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.arch"})
@EnableDiscoveryClient
@EnableFeignClients("com.arch")
@ImportResource(locations = {"classpath*:**SpringContext.xml"})
@Slf4j
public class GatewayServerStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        final ConfigurableApplicationContext application = SpringApplication.run(GatewayServerStarter.class, args);
        ConfigurableEnvironment env = application.getEnvironment();
        String ip = NetUtil.getLocalhostStr();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        path = (path == null ? "" : path);
        log.info("\n----------------------------------------------------------\n\t" +
                "Application arch-gateway is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger-API: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GatewayServerStarter.class);
    }
}

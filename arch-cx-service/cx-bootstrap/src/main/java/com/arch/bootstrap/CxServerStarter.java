package com.arch.bootstrap;

import com.arch.boot.base.annotation.ArchSqlDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = { "com.arch.core.service" })
@EnableDiscoveryClient
@ImportResource(locations = {"classpath*:**SpringContext.xml", "classpath*:**provider.xml"})
@MapperScan(basePackages = "com.arch" , annotationClass = ArchSqlDao.class)
public class CxServerStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CxServerStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CxServerStarter.class);
    }
}

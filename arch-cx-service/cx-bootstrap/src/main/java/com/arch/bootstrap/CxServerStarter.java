package com.arch.bootstrap;

import com.arch.boot.base.annotation.ArchSqlDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = { "com.arch" })
@EnableDiscoveryClient
@ImportResource(locations = {"classpath*:**SpringContext.xml", "classpath*:**provider.xml"})
@MapperScan(basePackages = "com.arch.core.dao" , annotationClass = ArchSqlDao.class)
@PropertySource(value = {"classpath:application.properties"})
public class CxServerStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CxServerStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CxServerStarter.class);
    }
}

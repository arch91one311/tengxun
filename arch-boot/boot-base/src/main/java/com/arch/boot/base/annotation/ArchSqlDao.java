package com.arch.boot.base.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 *
 * @author
 * @version 2013-8-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface ArchSqlDao {

}

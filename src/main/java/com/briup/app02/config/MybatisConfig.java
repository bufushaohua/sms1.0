package com.briup.app02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.app03.dao")//告诉mybatis我们的映射接口写在了哪个地方
public class MybatisConfig {

}
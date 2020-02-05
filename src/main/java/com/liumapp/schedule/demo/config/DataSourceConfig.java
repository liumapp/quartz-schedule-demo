package com.liumapp.schedule.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * file DataSourceConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/5
 */
@Configuration
@ConditionalOnProperty(name = "com.liumapp.schedule.datasource")
public class DataSourceConfig {



}

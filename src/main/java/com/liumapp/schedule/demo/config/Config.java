package com.liumapp.schedule.demo.config;

import com.liumapp.schedule.demo.config.spring.AutoWiringSpringBeanJobFactory;
import org.quartz.spi.JobFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
public class Config {

    @Bean
    @ConfigurationProperties(prefix = "liumapp.schedule.demo")
    public CoreParams coreParams(){
        CoreParams coreParams = new CoreParams();
        return coreParams;
    }

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    

}

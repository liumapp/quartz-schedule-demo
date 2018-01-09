package com.liumapp.schedule.demo.jobs;

import com.liumapp.schedule.demo.service.HelloService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liumapp on 1/9/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class HelloJob implements Job{

    @Autowired
    private HelloService helloService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        helloService.sayHello("a simple job");
    }

}

package com.liumapp.schedule.demo.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.util.StopWatch;

/**
 * file MakeAppleJob.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/6
 */
public class MakeAppleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("ready to make apple");

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}

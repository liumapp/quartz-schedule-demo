package com.liumapp.schedule.demo.jobs;

import com.alibaba.fastjson.JSON;
import com.liumapp.schedule.demo.dto.AppleParams;
import com.liumapp.schedule.demo.dto.BaseJobParams;
import com.liumapp.schedule.demo.mapper.QuartzJobMapper;
import com.liumapp.schedule.demo.model.QuartzJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.impl.JobExecutionContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * file MakeAppleJob.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/6
 */
@Component
public class MakeAppleJob implements Job {

    @Autowired
    private QuartzJobMapper quartzJobMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("ready to make apple at " + new Date());
        AppleParams appleParams = JSON.parseObject(
                (String) jobExecutionContext.getMergedJobDataMap().get(BaseJobParams.jobDataKey),
                AppleParams.class
        );
        System.out.println("we made a apple which color is " + appleParams.getColor() + " and its price is :" + appleParams.getPrice());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        //更新db状态，将任务标记为成功完成
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(appleParams.getId());
        quartzJob.setStatus((byte) 1);
        quartzJobMapper.updateByPrimaryKey(quartzJob);
    }
}

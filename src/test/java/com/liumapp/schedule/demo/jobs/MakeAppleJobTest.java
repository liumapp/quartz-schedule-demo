package com.liumapp.schedule.demo.jobs;

import com.alibaba.fastjson.JSON;
import com.liumapp.schedule.demo.Main;
import com.liumapp.schedule.demo.dto.AppleParams;
import com.liumapp.schedule.demo.dto.BaseJobParams;
import com.liumapp.schedule.demo.mapper.QuartzJobMapper;
import com.liumapp.schedule.demo.model.QuartzJob;
import com.liumapp.schedule.demo.utils.TimeUtils;
import com.liumapp.schedule.demo.utils.UIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * file MakeAppleJobTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class MakeAppleJobTest {

    @Autowired
    private QuartzJobMapper quartzJobMapper;

    /**
     * save quartz job info to db
     */
    @Test
    public void createMissionToDb () {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        AppleParams appleParams = new AppleParams(TimeUtils.fromDateToMilSec("2020-02-07 12:15:00"),
                UIDUtil.nextId(), "red", 3.5F);
        QuartzJob quartzJob = QuartzJob.builder()
                .id(appleParams.getId())
                .jobName("make-apple")
                .groupId("make-apple-group")
                .triggerId("make-apple")
                .paramsJson(appleParams.toJsonParams())
                .jobClass(MakeAppleJob.class.getName())
                .jobParamsClass(AppleParams.class.getName())
                .createTime(new Date())
                .build();
        quartzJobMapper.insertSelective(quartzJob);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis() + "ms");
    }

    /**
     * load mission from db and execute it .
     */
    @Test
    public void execute() {
        //load mission which status = 0
        List<QuartzJob> quartzJobs = quartzJobMapper.selectActiveDetailJobs(MakeAppleJob.class.getName());
        quartzJobs.stream().forEach(quartzJob -> {
            Class jobClz = null;

            try {
                jobClz = Class.forName(quartzJob.getJobClass());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            BaseJobParams baseJobParams = JSON.parseObject(quartzJob.getParamsJson(), BaseJobParams.class);

            JobDetail jobDetail = JobBuilder.newJob(jobClz)
                    .withIdentity(quartzJob.getId().toString(), quartzJob.getGroupId())
                    .usingJobData(BaseJobParams.jobDataKey, quartzJob.getParamsJson())
                    .build();

//            Trigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity(quartzJob.getTriggerId(), quartzJob.getGroupId())
//                    .startAt(DateBuilder.futureDate())
//                    .build();

        });

    }


}
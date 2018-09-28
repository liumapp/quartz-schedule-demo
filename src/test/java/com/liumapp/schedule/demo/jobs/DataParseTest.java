package com.liumapp.schedule.demo.jobs;

import com.liumapp.schedule.demo.Main;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by liumapp on 1/10/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class DataParseTest {

    @Autowired
    private Scheduler scheduler;

    /**
     * demo2
     * send paramter to jobs.
     * @throws SchedulerException quartz's
     * @throws InterruptedException thread's
     */
    @Test
    public void parameterTest () throws SchedulerException, InterruptedException {
        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(DataParseJob.class)
                .withIdentity("dataParseJob", "group2") // name "dataParseJob", group "group2"
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group2")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        // make quartz keep going
        while(true) {
            Thread.sleep(3000);
        }
    }

    /**
     * demo3
     * 自动将parameter参数写入jobs的属性中
     */
    @Test
    @Ignore
    public void parameterAutoWriteTest () throws SchedulerException, InterruptedException {
        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(HighLevelParameterJob.class)
                .withIdentity("highLevel", "group3") // name "highLevel", group "group3"
                .usingJobData("Msg", "Hello World!")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group3")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        while(true) {
            Thread.sleep(3000);
        }
    }

}



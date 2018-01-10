package com.liumapp.schedule.demo.jobs;

import com.liumapp.schedule.demo.Main;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liumapp on 1/10/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class SimpleTest {

    @Autowired
    private Scheduler scheduler;

    /**
     * demo1
     * simple start
     * say something every 10 seconds.
     */
    @Test
    @Ignore
    public void demo1Test () throws SchedulerException, InterruptedException {

        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        // make job keep going
        while (true) {
            Thread.sleep(3000);
        }

    }

    /**
     * demo 4
     * 每隔5秒执行一次
     * @throws SchedulerException quartz's
     * @throws InterruptedException thread's
     */
    @Test
    @Ignore
    public void demo4Test () throws SchedulerException, InterruptedException {
        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1", "group1")
                .build();

        SimpleTrigger trigger;
        trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(DateBuilder.futureDate(5 , DateBuilder.IntervalUnit.SECOND)) // some Date
                .forJob("job1", "group1") // identify job with name, group strings
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        while(true) {
            Thread.sleep(3000);
        }
    }

    /**
     * demo5
     * start job after 5 seconds
     * do job everty 10 seconds
     * only repeat for 10 times.
     */
    @Test
    @Ignore
    public void demo5Test () throws SchedulerException, InterruptedException {
        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job2", "group2")
                .build();

        SimpleTrigger trigger;
        trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group2")
                .startAt(DateBuilder.futureDate(5 , DateBuilder.IntervalUnit.SECOND)) // some Date
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .withRepeatCount(10))
                .forJob("job2", "group2") // identify job with name, group strings
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        while(true) {
            Thread.sleep(3000);
        }
    }

    /**
     * demo 6
     * start a job right now
     * repeat every 5 minutes , until 16:00
     *
     */
    @Test
    @Ignore
    public void demo6Test () throws SchedulerException, InterruptedException {
        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job3", "group3")
                .build();

        SimpleTrigger trigger;
        trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group3")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(5)
                        .repeatForever())
                .endAt(DateBuilder.dateOf(16, 0, 0))
                .forJob("job3", "group3") // identify job with name, group strings
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        while(true) {
            Thread.sleep(3000);
        }
    }




}

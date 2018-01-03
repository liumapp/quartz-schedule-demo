package com.liumapp.schedule.demo.controller;

import com.liumapp.schedule.demo.jobs.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by liumapp on 1/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping(path = "/trigger")
public class SimpleTriggerController {

    @RequestMapping(path = "")
    public String index () throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Date now = new Date();

        // and start it off
        scheduler.start();

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

        return "success";
    }

    @RequestMapping(path = "repeat")
    public String repeat () throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Date now = new Date();

        // and start it off
        scheduler.start();

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

        return "success";
    }

}

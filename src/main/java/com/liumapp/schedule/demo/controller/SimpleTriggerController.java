package com.liumapp.schedule.demo.controller;

import com.liumapp.schedule.demo.jobs.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by liumapp on 1/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping(path = "trigger")
public class SimpleTriggerController {

    public String index () throws SchedulerException {
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//        // and start it off
//        scheduler.start();
//
//        // define the job and tie it to our SimpleJob class
//        JobDetail job = JobBuilder.newJob(SimpleJob.class)
//                .withIdentity("job1", "group1")
//                .build();
//
//        SimpleTrigger trigger;
//        trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .startAt(DateBuilder.futureDate()) // some Date
//                .forJob("job1", "group1") // identify job with name, group strings
//                .build();
//
//        // Tell quartz to schedule the job using our trigger
//        scheduler.scheduleJob(job, trigger);
//
//        return "success";
    }

}

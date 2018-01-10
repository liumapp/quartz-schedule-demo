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
@RequestMapping(path = "/trigger")
public class SimpleTriggerController {

    /**
     * demo7
     */
    @RequestMapping(path = "evenhour")
    public String onlyHour () throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Date now = new Date();

        // and start it off
        scheduler.start();

        // define the job and tie it to our SimpleJob class
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job4", "group4")
                .build();

        SimpleTrigger trigger;
        trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger4", "group4")
                .startAt(DateBuilder.evenHourDate(null)) // get the next even-hour (minutes and seconds zero ("00:00"))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(2)
                        .repeatForever())
                .forJob("job4", "group4") // identify job with name, group strings
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
        return "success";
    }

}

package com.liumapp.schedule.demo.controller;

import com.liumapp.schedule.demo.jobs.DataParseJob;
import com.liumapp.schedule.demo.jobs.HighLevelParameterJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by liumapp on 12/29/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping(path = "/parameter")
public class ParameterController {

    /**
     * demo2
     */
    @RequestMapping(path = "/")
    public String index() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();



        return "success";

    }

    /**
     * demo2
     * "高级"版本
     */
    @RequestMapping(path = "/advanced")
    public String advanced () throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

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
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        return "success";
    }

}

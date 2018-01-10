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


        return "success";
    }

}

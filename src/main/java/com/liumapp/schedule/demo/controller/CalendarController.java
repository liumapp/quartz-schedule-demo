package com.liumapp.schedule.demo.controller;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liumapp on 1/1/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping(path = "calendar")
public class CalendarController {

    @RequestMapping(path = "")
    public String index() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

        HolidayCalendar cal = new HolidayCalendar();
//        cal.addExcludedDate( someDate );
//        cal.addExcludedDate( someOtherDate );

        scheduler.addCalendar("myHolidays", cal, false);


        Trigger t = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                .forJob("myJob")
                .withSchedule(dailyAtHourAndMinute(9, 30)) // execute job daily at 9:30
                .modifiedByCalendar("myHolidays") // but not on holidays
                .build();

// .. schedule job with trigger

        Trigger t2 = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger2")
                .forJob("myJob2")
                .withSchedule(dailyAtHourAndMinute(11, 30)) // execute job daily at 11:30
                .modifiedByCalendar("myHolidays") // but not on holidays
                .build();

        scheduler.scheduleJob(job, trigger);

        return "success";
    }

}

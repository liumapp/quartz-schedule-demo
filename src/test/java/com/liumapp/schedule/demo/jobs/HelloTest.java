package com.liumapp.schedule.demo.jobs;

import com.liumapp.schedule.demo.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liumapp on 1/9/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class HelloTest {

    @Autowired
    private Scheduler scheduler;

    @Test
    public void testHello () throws SchedulerException {
        scheduler.start();

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
            .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail , trigger);

    }


}

package com.liumapp.schedule.demo.service.impl;

import com.liumapp.schedule.demo.model.QuartzJob;
import com.liumapp.schedule.demo.jobs.SqlJob;
import com.liumapp.schedule.demo.mapper.QuartzJobMapper;
import com.liumapp.schedule.demo.service.SqlJobService;
import com.liumapp.schedule.demo.utils.TimeUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@Service
public class SqlServiceImpl implements SqlJobService {

    @Autowired
    private QuartzJobMapper quartzJobMapper;

    @Autowired
    private Scheduler scheduler;

//    @PostConstruct
//    public void init() {
//
//        List<QuartzJob> list = quartzJobMapper.selectAll();
//
//        list.forEach(quartzJob -> {
//            Class clz = null;
//            try {
//                clz = Class.forName(quartzJob.getJobClass());
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            int time =  TimeUtils.getTimeSecond(quartzJob.getExecTime());
//            System.out.println(quartzJob.getJobName()+"将于"+time+"s后执行一次");
//            JobDetail job = JobBuilder.newJob(clz)
//                    .withIdentity(quartzJob.getJob(), quartzJob.getGroup())
//                    .usingJobData("jobSays", quartzJob.getParams())
//                    .build();
//
//            Trigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity(quartzJob.getTriggerName(), quartzJob.getGroup())
//                    .startAt(DateBuilder.futureDate(time, DateBuilder.IntervalUnit.SECOND))
//                    .withSchedule(SimpleScheduleBuilder.simpleSchedule())
//                    .build();
//
//            try {
//                scheduler.scheduleJob(job, trigger);
//            } catch (SchedulerException e) {
//                e.printStackTrace();
//            }
//        });
//    }

    @Override
    public int addJob(SqlJob sqlJob) {
        return 0;
    }
}

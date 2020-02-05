package com.liumapp.schedule.demo.jobs;

import com.alibaba.fastjson.JSON;
import com.liumapp.schedule.demo.Main;
import com.liumapp.schedule.demo.model.QuartzJob;
import com.liumapp.schedule.demo.mapper.QuartzJobMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@SpringBootTest(classes = Main.class)
@RunWith(SpringRunner.class)
public class SqlTest {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private QuartzJobMapper quartzJobMapper;


    @Test
    public void AddJob() throws SchedulerException {
        for (int i = 1; i < 21; i++) {
            String jobid = "job-"+i;
            String groupid = "group-"+i;
            String triggerid = "trigger-"+i;


            Map<String,String> map = new HashMap<String,String>();
            map.put("jobSays","这是从数据库读取的数据哦");
            map.put("jobName","这是时间调度任务_"+i);
            String id = UUID.randomUUID().toString().replaceAll("-","");
            map.put("id",id);
            QuartzJob quartzJob = new QuartzJob();
            Date now = new Date();
            quartzJob.setId(id);
            quartzJob.setCreateTime(now);
            quartzJob.setGroup(groupid);
            quartzJob.setJob(triggerid);
            quartzJob.setTriggerName(triggerid);
            quartzJob.setJobClass(SqlJob.class.getName());
            quartzJob.setExecTime(new Date(now.getTime() + 10000*i));
            quartzJob.setJobName("时间调度_"+i);
            quartzJob.setStatus((byte)0);
            quartzJob.setParams(JSON.toJSONString(map));

            quartzJobMapper.insertSelective(quartzJob);

            JobDetail job = JobBuilder.newJob(SqlJob.class)
                    .withIdentity(jobid, groupid)
                    .usingJobData("jobSays", quartzJob.getParams())
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerid, groupid)
                    .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
        }
    }

}

package com.liumapp.schedule.demo.jobs;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.schedule.demo.model.QuartzJob;
import com.liumapp.schedule.demo.mapper.QuartzJobMapper;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
public class SqlJob implements Job {
    @Autowired
    private QuartzJobMapper quartzJobMapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");

        JSONObject jsonObject = JSONObject.parseObject(jobSays);
        String id = jsonObject.getString("id");
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setId(id);
        quartzJob.setStatus((byte)1);
        quartzJobMapper.updateByPrimaryKeySelective(quartzJob);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(jobSays+"-------------"+format.format(new Date()));
    }
}

package com.liumapp.schedule.demo.jobs;

import org.quartz.*;

import java.util.HashMap;

/**
 * Created by liumapp on 12/29/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class HighLevelParameterJob implements Job {

    private String Msg;

    public HighLevelParameterJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();

        System.out.println("HighLevelParameterJob's Msg is : " + this.Msg);
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}

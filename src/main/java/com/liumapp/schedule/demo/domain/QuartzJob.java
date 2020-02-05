package com.liumapp.schedule.demo.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * file QuartzJob.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/5
 */
@Data
public class QuartzJob {

    @Id
    @GeneratedValue(generator = "JDBC")
    String id;

    String jobName;

    String job;

    String group;

    String triggerName;

    Date execTime;

    String params;

    Byte status;

    String jobClass;

    Date createTime;

}
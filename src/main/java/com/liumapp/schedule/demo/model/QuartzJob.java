package com.liumapp.schedule.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartzJob {

    @Id
    @GeneratedValue(generator = "JDBC")
    Long id;

    String jobName;

    String groupId;

    String triggerId;

    String paramsJson;

    /**
     * 0: 待执行
     * 1: 执行完成
     * 2: 执行失败
     */
    Byte status;

    String jobClass;

    String jobParamsClass;

    Date execTime;

    Date createTime;

    Byte isDelete;

}
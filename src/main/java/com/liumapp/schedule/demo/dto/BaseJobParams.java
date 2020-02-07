package com.liumapp.schedule.demo.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * file BaseJobParams.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/6
 */
public class BaseJobParams {

    public static String jobDataKey = "jobKey";

    /**
     * 开始执行任务的时间，单位linux时间戳毫秒
     */
    @Getter
    @Setter
    protected Long startMakeTime;

    @Getter
    @Setter
    protected Long id;

    public BaseJobParams() {
    }

    public BaseJobParams(Long startMakeTime, Long id) {
        this.startMakeTime = startMakeTime;
        this.id = id;
    }

    public String toJsonParams() {
        return JSON.toJSONString(this);
    }

    public BaseJobParams fromJsonParams(String jsonParams) {
        return JSON.parseObject(jsonParams, BaseJobParams.class);
    }
}

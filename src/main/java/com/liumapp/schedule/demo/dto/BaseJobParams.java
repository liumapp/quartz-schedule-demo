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
public abstract class BaseJobParams {

    public static String jobDataKey = "jobKey";

    @Getter
    @Setter
    protected Long id;

    public BaseJobParams() {
    }

    public BaseJobParams(Long id) {
        this.id = id;
    }

    public abstract String toJsonParams();

    public abstract BaseJobParams fromJsonParams(String jsonParams);

}

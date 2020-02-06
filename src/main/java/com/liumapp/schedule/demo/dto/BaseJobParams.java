package com.liumapp.schedule.demo.dto;

import com.alibaba.fastjson.JSON;

/**
 * file BaseJobParams.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/6
 */
public abstract class BaseJobParams {

    private Long id;

    public abstract String toJsonParams();

    public abstract BaseJobParams fromJsonParams(String jsonParams);

}

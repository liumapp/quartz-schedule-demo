package com.liumapp.schedule.demo.dto;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * file SqlJobParams.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/6
 */
@Component
@Scope("prototype")
public class SqlJobParams extends BaseJobParams {

    @Override
    public String toJsonParams() {
        return JSON.toJSONString(this);
    }

    @Override
    public SqlJobParams fromJsonParams(String jsonParams) {
        return JSON.parseObject(jsonParams, SqlJobParams.class);
    }

}

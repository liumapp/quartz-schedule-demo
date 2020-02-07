package com.liumapp.schedule.demo.dto;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * file AppleParams.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/6
 */
@Component
@Scope("prototype")
@Data
public class AppleParams extends BaseJobParams {

    private String color;

    private float price;

    public AppleParams() {
    }

    public AppleParams(Long id, String color, float price) {
        super(id);
        this.color = color;
        this.price = price;
    }

    @Override
    public String toJsonParams() {
        return JSON.toJSONString(this);
    }

    @Override
    public BaseJobParams fromJsonParams(String jsonParams) {
        return JSON.parseObject(jsonParams, AppleParams.class);
    }
}

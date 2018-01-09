package com.liumapp.schedule.demo.service.impl;

import com.liumapp.schedule.demo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by liumapp on 1/9/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String msg) {
        System.out.println("hello world , and say " + msg);
    }

}

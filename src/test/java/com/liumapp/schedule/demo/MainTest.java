package com.liumapp.schedule.demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liumapp on 1/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class MainTest {

    @Test
    public void getTimeTest () {
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String dateString = format.format(currentTime);

        String Hour = dateString.substring(11 , 13);
        String Min = dateString.substring(14 , 16);

        System.out.println(dateString);
        System.out.println(Hour);
        System.out.println(Min);
    }

    @Test
    public void setTimeTest () {
        
    }

}

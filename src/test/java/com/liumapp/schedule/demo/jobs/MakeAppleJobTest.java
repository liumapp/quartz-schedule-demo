package com.liumapp.schedule.demo.jobs;

import com.liumapp.schedule.demo.Main;
import com.liumapp.schedule.demo.dto.AppleParams;
import com.liumapp.schedule.demo.model.QuartzJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * file MakeAppleJobTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2020/2/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class MakeAppleJobTest {

    @Test
    public void createMissionToDb () {
        AppleParams appleParams = new AppleParams(UUID.randomUUID().getLeastSignificantBits(), "red", 3.5F);
        QuartzJob quartzJob = QuartzJob.builder()
                .id(appleParams.getId())
                .jobName("make-apple")
                .groupId("make-apple-group-01")
                .triggerId("make-apple")

                .build();
    }

    @Test
    public void execute() {

    }


}
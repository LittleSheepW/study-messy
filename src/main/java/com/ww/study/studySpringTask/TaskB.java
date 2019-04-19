package com.ww.study.studySpringTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Program: boot-study
 * @Description: SpringTask TaskB
 * @Author: Sun
 * @Create: 2019-04-19 10:43
 * @Version: 1.0
 **/
@Component
public class TaskB {
    @Scheduled(cron="0/10 * *  * * ? ")   //每10秒执行一次
    public void aTask() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + "*********A任务每10秒执行一次进入测试");
    }
}

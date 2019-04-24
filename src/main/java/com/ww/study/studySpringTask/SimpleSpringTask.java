package com.ww.study.studySpringTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Program: study-messy
 * @Description: SpringBoot集成SpringTask实现定时任务,最简单的定时器任务
 * @Author: Sun
 * @Create: 2019-04-19 10:31
 * @Version: 1.0
 **/
@Component
@Slf4j
public class SimpleSpringTask {

    @Scheduled(cron = "*/5 * * * * ?")
    public void task1() {
        log.info("当前时间:{}\t,Hello,Spring Task", new Date());
    }
}

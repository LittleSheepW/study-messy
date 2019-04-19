package com.ww.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Program: boot-study
 * @Description: 定时任务配置类，配置多线程执行定时任务，任务与任务之间互不影响
 * Scheduled这个注解给我们带了很大的方便，我们只要加上该注解，并且根据需求设置好就可以使用定时任务了。
 * 但是，我们需要注意的是，定时任务并不一定会按时执行。
 * 因为使用@Scheduled 的定时任务虽然是异步执行的，但是不同的定时任务之间并不是并行的，
 * 在其中一个定时任务没有执行完之前，其他的定时任务即使是到了执行时间，也是不会执行的，它们会进行排队。
 * 也就是如果你想你不同的定时任务互不影响，到时间就会执行，那么你最好将配置多线程执行定时任务。
 * 这样定时任务其实就相当于调用了一个线程执行任务，多个线程互相不影响。
 * @Author: Sun
 * @Create: 2019-04-19 10:50
 * @Version: 1.0
 **/
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        //指定定时任务线程池大小
        return Executors.newScheduledThreadPool(15);
    }
}

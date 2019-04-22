package com.ww.study.studyQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 实现Job接口，定义定时任务执行内容
 */
public class SchedulerQuartzJob implements Job{
    private void before(){
        System.out.println("任务开始执行");
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        System.out.println("开始："+System.currentTimeMillis());
        // TODO 业务
        System.out.println("结束："+System.currentTimeMillis());
        after();
    }

    private void after(){
        System.out.println("任务执行完毕");
    }

}
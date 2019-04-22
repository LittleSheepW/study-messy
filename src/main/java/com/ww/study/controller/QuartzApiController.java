package com.ww.study.controller;

import com.ww.study.studyQuartz.QuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 封装简易API，方便对定时任务的操作
 */
@RestController
@RequestMapping("/quartz")
public class QuartzApiController {
    @Autowired
    private QuartzScheduler quartzScheduler;

    /**
     * 开启定时任务
     */
    @RequestMapping("/start")
    public void startQuartzJob() {
        try {
            quartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取定时任务信息
     * @param name
     * @param group
     * @return
     */
    @RequestMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = quartzScheduler.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 修改定时任务的执行时间
     * @param name
     * @param group
     * @param time
     * @return
     */
    @RequestMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        try {
            flag = quartzScheduler.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 暂停单个任务
     * @param name
     * @param group
     */
    @RequestMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzScheduler.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停所有任务
     */
    @RequestMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复单个任务继续执行
     * @param name
     * @param group
     */
    @RequestMapping(value = "/resume")
    public void resume(String name, String group) {
        try {
            quartzScheduler.resumeJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复所有任务继续执行
     * @param name
     * @param group
     */
    @RequestMapping(value = "/resumeAll")
    public void resumeAllJob(String name, String group) {
        try {
            quartzScheduler.resumeAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除单个定时任务
     * @param name
     * @param group
     */
    @RequestMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            quartzScheduler.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}

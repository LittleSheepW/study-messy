package com.ww.study.studySpringTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Program: boot-study
 * @Description: SpringTask TaskA
 * 在不配置定时任务线程池时，两个定时任务是存在问题的，前面的任务没有执行完毕，
 * 就算第二个任务到了执行任务的时间，第二个任务就会处于排队等待状态
 * @see com.ww.study.config.ScheduleConfig 定时任务线程池配置类
 * @Author: Sun
 * @Create: 2019-04-19 10:42
 * @Version: 1.0
 **/
@Component
public class TaskA {

    /**
     * cron表达式   Seconds Minutes Hours DayofMonth Month DayofWeek Year
     * 1  秒（0~59）
     * 2  分钟（0~59）
     * 3  小时（0~23）
     * 4  天（0~31）
     * 5  月（0~11）
     * 6  星期（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     * 7  年份（1970－2099）
     * 其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。
     * 由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?。
     *
     * 每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是：
     * (1)*:表示匹配该域的任意值，假如在Minutes域使用*, 即表示每分钟都会触发事件。
     * (2)?:只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。
     *      因为DayofMonth和 DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，
     *      则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。
     * (3)-:表示范围，例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
     * (4)/:表示起始时间开始触发，然后每隔固定时间触发一次，例如在Minutes域使用5/20,则意味着每小时第5分钟开始触发，然后每隔20分钟执行一次。
     * (5),:表示列出枚举值值。例如：在Minutes域使用5,20，则意味着在5和20分触发。
     */
    @Scheduled(cron = "0/5 * *  * * ? ")   //每5秒执行一次
    public void aTask() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + "*********A任务每5秒执行一次进入测试");
    }
}

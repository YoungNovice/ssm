package com.xuanyang.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;


/**
 * cron表达式 【秒】【分】【时】【日】【月】【周】【年】
 * 
 * @author xuanyang
 */
public class HelloSchedualer {

    public static void main(String[] args) {

        JobBuilder jobBuilder = JobBuilder.newJob(HelloWorldJob.class);
        jobBuilder.usingJobData("myint", 1);
        // 通过JobBuilder 创建jobDetail
        JobDetail jobDetail = jobBuilder.withIdentity("myjob", "group1").build();
        // 通过triggerBuilder 创建 trigger
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity("myTrigger", "group1");
//        triggerBuilder.startNow();
        // 设置开始执行时间
        triggerBuilder.startAt(new Date(System.currentTimeMillis()+ 3000));
        // 设置结束执行时间
        triggerBuilder.endAt(new Date(System.currentTimeMillis()+ 20000));
        triggerBuilder.usingJobData("myint", 2);

        // 创建scheduleBuilder triggerBuilder 需要用到它
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        scheduleBuilder.withIntervalInSeconds(2);
//        SimpleTrigger.REPEAT_INDEFINITELY
        scheduleBuilder.withRepeatCount(3);


        triggerBuilder.withSchedule(scheduleBuilder);
        // 创建Trigger
        Trigger trigger = triggerBuilder.build();

        StdSchedulerFactory factory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.start();
            // 挂起scheduler 挂起的scheduler 是可以重新start的
//            scheduler.standby();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }



    }
}

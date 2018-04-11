package com.xuanyang.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobTester {

    @Test
    public void testCron() {
        JobBuilder jobBuilder = JobBuilder.newJob(HelloWorldJob.class);
        // 通过JobBuilder 创建jobDetail
        JobDetail jobDetail = jobBuilder.withIdentity("myjob", "group1").build();

        // 通过triggerBuilder 创建 trigger
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity("myTrigger", "group1");
        triggerBuilder.startNow();

        String cron = "* * * * * ? *";
        // 创建scheduleBuilder triggerBuilder 需要用到它
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        triggerBuilder.withSchedule(scheduleBuilder);
        // 创建Trigger
        Trigger trigger = triggerBuilder.build();

        StdSchedulerFactory factory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            while (true) {

            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }


    /**
     * quartz 三要素
     * jobDetail 是对job 的封装 它用builder 来构造
     * Trirger 是对任务的执行时机的封装 用builder来构造 什么时候执行啊 执行几次都是它来控制
     *
     *
     * scheduler 是对任务的控制 启动 停止等操作都是由它控制 它由factory 构造
     */
    @Test
    public void testSimple() {

        JobBuilder jobBuilder = JobBuilder.newJob(HelloWorldJob.class);
        // 通过JobBuilder 创建jobDetail
        JobDetail jobDetail = jobBuilder.withIdentity("myjob", "group1").build();

        // 通过triggerBuilder 创建 trigger
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity("myTrigger", "group1");
        triggerBuilder.startNow();

        // 创建scheduleBuilder triggerBuilder 需要用到它
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        scheduleBuilder.withIntervalInSeconds(1);
        scheduleBuilder.repeatForever();


        triggerBuilder.withSchedule(scheduleBuilder);
        // 创建Trigger
        Trigger trigger = triggerBuilder.build();

        StdSchedulerFactory factory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            while (true) {

            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}

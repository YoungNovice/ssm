package com.xuanyang.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * 
 * 
 * @author xuanyang
 */
public class HelloSchedualer {

    public static void main(String[] args) {

        JobBuilder jobBuilder = JobBuilder.newJob(HelloWorldJob.class);
        // 通过JobBuilder 创建jobDetail
        JobDetail jobDetail = jobBuilder.withIdentity("myjob", "group1").build();

        // 通过triggerBuilder 创建 trigger
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity("myTrigger", "group1");
        triggerBuilder.startNow();

        // 创建scheduleBuilder triggerBuilder 需要用到它
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        scheduleBuilder.withIntervalInSeconds(2);
        scheduleBuilder.repeatForever();


        triggerBuilder.withSchedule(scheduleBuilder);
        // 创建Trigger
        Trigger trigger = triggerBuilder.build();

        StdSchedulerFactory factory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }



    }
}

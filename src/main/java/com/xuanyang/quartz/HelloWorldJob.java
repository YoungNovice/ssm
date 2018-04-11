package com.xuanyang.quartz;

import org.quartz.*;


/**
 * @author xuanyang
 *
 * job 声明周期 每次scheduler 执行job 的时候
 * 在调用execute 方法之前会创建一个job(通过反射 所以job一定要有无参数的构造方法)
 *
 */
public class HelloWorldJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        TriggerKey triggerKey = context.getTrigger().getKey();

//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//        JobDataMap jobDataMap = context.getTrigger().getJobDataMap();
        // trigger中key一样的会覆盖jobDetail的数据
        JobDataMap dataMap = context.getMergedJobDataMap();
        System.out.println(System.currentTimeMillis());
        System.out.println("Hello World");
    }
}

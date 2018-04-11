package com.xuanyang.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author xuanyang
 *
 * job 声明周期 每次scheduler 执行job 的时候
 * 在调用execute 方法之前会创建一个job(通过反射 所以job一定要有无参数的构造方法)
 *
 */
public class HelloWorldJob implements Job {

    /**
     * 在job 中定义好field 和get set  就会自动赋值
     * 会自动从JobDataMap 中取数据
     * */
    private int myint;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        map(context);
        time(context);
        System.out.println("Hello World" + myint);
    }

    private void time(JobExecutionContext context) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = context.getTrigger().getStartTime();
        Date endTime = context.getTrigger().getEndTime();
        System.out.println("start Time is: "+ format.format(startTime));
        System.out.println("end Time is: "+ format.format(endTime));
    }

    public void map(JobExecutionContext context) {
        JobKey jobKey = context.getJobDetail().getKey();
        TriggerKey triggerKey = context.getTrigger().getKey();
//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//        JobDataMap jobDataMap = context.getTrigger().getJobDataMap();
        // trigger中key一样的会覆盖jobDetail的数据
        JobDataMap dataMap = context.getMergedJobDataMap();
    }

    public int getMyint() {
        return myint;
    }

    public void setMyint(int myint) {
        this.myint = myint;
    }
}

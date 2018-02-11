package com.kevin.quartz.helloworld;

import org.quartz.*;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

/**
 * @类名: Main
 * @包名：com.kevin.quartz
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/2/11 10:57
 * @版本：1.0
 * @描述：
 */
public class Main {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        sched.start();

        // define the job and tie it to our DumbJob class
        JobDetail job = newJob(DumbJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        // Trigger the job to run now
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
    }
}

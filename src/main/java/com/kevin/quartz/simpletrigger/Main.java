package com.kevin.quartz.simpletrigger;

import com.kevin.quartz.helloworld.DumbJob;
import org.quartz.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * @类名: Main
 * @包名：com.kevin.quartz.simpletrigger
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/2/11 15:40
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

        SimpleTrigger trigger  = newTrigger()
                .withIdentity("trigger3", "group1")
                .startNow()  // if a start time is not given (if this line were omitted), "now" is implied
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .withRepeatCount(10)) // note that 10 repeats will give a total of 11 firings
                .forJob(job) // identify job with handle to its JobDetail itself
                .build();

        sched.scheduleJob(job, trigger);
    }
}

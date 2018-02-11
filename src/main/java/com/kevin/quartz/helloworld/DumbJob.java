package com.kevin.quartz.helloworld;

import org.quartz.*;

/**
 * @类名: DumbJob
 * @包名：com.kevin.quartz
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2017/10/10 10:23
 * @版本：1.0
 * @描述：
 */
public class DumbJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }
}

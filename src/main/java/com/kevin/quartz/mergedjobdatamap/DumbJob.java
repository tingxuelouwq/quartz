package com.kevin.quartz.mergedjobdatamap;

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
    private String jobSays;
    private float myFloatValue;

    public DumbJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getMergedJobDataMap();
        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }
}

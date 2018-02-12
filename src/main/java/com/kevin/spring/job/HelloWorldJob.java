package com.kevin.spring.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @类名: HelloWorldJob
 * @包名：com.kevin.spring.job
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/2/12 10:25
 * @版本：1.0
 * @描述：
 */
public class HelloWorldJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("This is a first spring combine quartz !");
        log.info("Welcome to Spring_Quartz World!"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        log.info("Let's begin ! \n \n");
    }
}

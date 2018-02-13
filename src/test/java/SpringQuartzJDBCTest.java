import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.SimpleScheduleBuilder.repeatSecondlyForTotalCount;

import com.kevin.spring.job.HelloWorldJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @类名: SpringQuartzJDBCTest
 * @包名：PACKAGE_NAME
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/2/12 11:15
 * @版本：1.0
 * @描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_quartz_jdbc.xml"})
public class SpringQuartzJDBCTest {

    @Test
    public void test() {
        try {
            // 1. 创建任务
            JobDetail job = newJob(HelloWorldJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            // 2. 创建触发器
            Trigger trigger = newTrigger()
                    .withSchedule(repeatSecondlyForTotalCount(5))
                    .build();
            // 3. 创建调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            // 4. 调度执行
            scheduler.scheduleJob(job, trigger);

            Thread.sleep(60 * 1000);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

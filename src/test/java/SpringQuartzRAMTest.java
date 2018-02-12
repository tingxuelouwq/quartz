import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @类名: SpringQuartzRAMTest
 * @包名：PACKAGE_NAME
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/2/12 10:40
 * @版本：1.0
 * @描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_quartz_ram.xml"})
public class SpringQuartzRAMTest {

    @Test
    public void testSpringQuartzRAM() throws InterruptedException {
        Thread.sleep(60 * 1000);
    }
}

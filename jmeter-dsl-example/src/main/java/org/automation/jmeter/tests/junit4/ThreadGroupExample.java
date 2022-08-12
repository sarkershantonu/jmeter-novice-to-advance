package org.automation.jmeter.tests.junit4;

import org.automation.jmeter.core.Junit4PerformancePerformanceTest;
import org.junit.Assert;
import org.junit.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class ThreadGroupExample extends Junit4PerformancePerformanceTest {

    @Test
    public void testThreadGroup() throws IOException {
        TestPlanStats report = testPlan(
                threadGroup("Checking Default Thread group", 5, 5,
                        httpSampler("https://bratahome.duckdns.org")))
                .run();
        //Assert.assertTrue("fails : Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())>=5L);

        Assert.assertTrue("Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())<=5L);
    }

}

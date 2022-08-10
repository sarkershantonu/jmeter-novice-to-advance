package org.automation.jmeter.tests.junit5;

import org.automation.jmeter.core.Junit5PerformanceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class ThreadGroupExample extends Junit5PerformanceTest {
    @Test
    public void testThreadGroup() throws IOException {
        TestPlanStats report = testPlan(
                threadGroup("Checking Default Thread group", 5, 5,
                        httpSampler("https://bratahome.duckdns.org")))
                .run();
        //Assert.assertTrue("fails : Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())>=5L);

        Assertions.assertTrue((report.overall().sampleTimePercentile99().getSeconds())<=5L,"Should be less than 5s");
    }
}

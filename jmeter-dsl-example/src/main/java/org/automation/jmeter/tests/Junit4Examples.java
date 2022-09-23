package org.automation.jmeter.tests;

import org.automation.jmeter.cofig.ContextLoader;
import org.automation.jmeter.steps.JmeterTestPlan;
import org.junit.Assert;
import org.junit.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class Junit4Examples {

    @Test
    public void testThreadGroup() throws IOException {
        TestPlanStats report = testPlan(
                threadGroup("Checking Default Thread group", 5, 5,
                        httpSampler("https://bratahome.duckdns.org")))
                .run();
        //Assert.assertTrue("fails : Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())>=5L);

        Assert.assertTrue("Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())<=5L);
    }

    @Test
    public void testThreadGroup2() throws IOException {
        TestPlanStats report = new JmeterTestPlan(
                new ContextLoader("threadgroup.ini").loadFromFolder("test-data"),
                new  ContextLoader("http.ini").loadFromFolder("test-data"))
                .getPlanWithIteration().run();
        Assert.assertTrue("Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())<=5L);

    }
}

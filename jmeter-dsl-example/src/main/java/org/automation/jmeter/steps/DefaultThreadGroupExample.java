package org.automation.jmeter.steps;

import org.junit.Assert;
import us.abstracta.jmeter.javadsl.core.DslTestPlan;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.util.Properties;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class DefaultThreadGroupExample {

    private Properties thread;
    private Properties http;

    public DefaultThreadGroupExample(Properties threadGroupData, Properties httpData) {
        this.thread=threadGroupData;
        this.http= httpData;
    }

    //todo
    public void runWithProperties(Properties properties) throws IOException {
        TestPlanStats report = testPlan(
                threadGroup(properties.getProperty("comments"),
                        Integer.valueOf(properties.getProperty("comments")),
                        Integer.valueOf(properties.getProperty("comments")),
                        httpSampler("https://bratahome.duckdns.org")))
                .run();
        //Assert.assertTrue("fails : Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())>=5L);

        Assert.assertTrue("Should be less than 5s",(report.overall().sampleTimePercentile99().getSeconds())<=5L);

    }
    public DslTestPlan getTestPlan(){
        return testPlan(
                threadGroup(thread.getProperty("comments"),
                        Integer.valueOf(thread.getProperty("comments")),
                        Integer.valueOf(thread.getProperty("comments")),
                        httpSampler(http.getProperty("BASE_UIRL"))));
    }
}

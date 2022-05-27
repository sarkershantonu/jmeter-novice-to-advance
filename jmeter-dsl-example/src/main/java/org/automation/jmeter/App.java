package org.automation.jmeter;

import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.time.Instant;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

/**
 * @author Shantonu Sarker on 5/26/2022
 */
public class App {
    public static void main(String[] args) throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup("DemoExecution",10,50,
                        httpSampler("https://jmeter.apache.org/")
                ),
                jtlWriter("demoExecution"+ Instant.now().toString().replace(":","_")+".jtl")
        ).run();
        System.out.println(stats.overall().sampleTimePercentile99().toString());
    }
}

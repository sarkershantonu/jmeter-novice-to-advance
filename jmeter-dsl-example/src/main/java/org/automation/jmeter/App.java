package org.automation.jmeter;

import org.automation.jmeter.cofig.ContextLoader;
import org.automation.jmeter.cofig.verifyer.VerifyDefaultThreadGroup;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;
import java.time.Instant;
import java.util.Properties;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

/**
 * @author Shantonu Sarker on 5/26/2022
 */
public class App {
    public static void main(String[] args) throws IOException {
        VerifyDefaultThreadGroup vft = new VerifyDefaultThreadGroup("threadgroup.ini");
        vft.printValues();
    }

    public static void demoRun() throws IOException {
        String jjtl_folder = "target/";
        TestPlanStats stats = testPlan(
                threadGroup("DemoExecution", 10, 50,
                        httpSampler("https://jmeter.apache.org/")
                ),
                jtlWriter(jjtl_folder + "demoExecution" + Instant.now().toString().replace(":", "_") + ".jtl")
        ).run();
        System.out.println(stats.overall().sampleTimePercentile99().toString());

    }
}

package org.automation.jmeter.tests.scripts;

import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class LoadScripts {

    public static TestPlanStats simpleThreadGroupExample() throws IOException {
        return testPlan(
                threadGroup("Checking Default Thread group", 5, 5,
                        httpSampler("https://bratahome.duckdns.org")))
                .run();
    }
}

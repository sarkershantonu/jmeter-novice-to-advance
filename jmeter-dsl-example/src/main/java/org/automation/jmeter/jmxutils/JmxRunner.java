package org.automation.jmeter.jmxutils;

import us.abstracta.jmeter.javadsl.core.DslTestPlan;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

public class JmxRunner {
    private final String jmxFilePath;

    public JmxRunner(String jmxFilePath) {
        this.jmxFilePath = jmxFilePath;
    }
    public TestPlanStats run() throws IOException {
        return DslTestPlan.fromJmx(this.jmxFilePath).run();
    }
}

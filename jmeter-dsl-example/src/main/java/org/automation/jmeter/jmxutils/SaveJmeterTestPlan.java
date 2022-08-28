package org.automation.jmeter.jmxutils;

import org.automation.jmeter.cofig.JavaProperties;
import us.abstracta.jmeter.javadsl.core.DslTestPlan;

import java.io.IOException;

public class SaveJmeterTestPlan {
    private final DslTestPlan testPlan;

    public SaveJmeterTestPlan(final DslTestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public void asJmx(final String name) {
        try {
            testPlan.saveAsJmx("JMX" + JavaProperties.FILE_SEPARATOR + name + ".jmx");
        } catch (IOException e) {
            throw new RuntimeException("Cant Save File", e);
        }
    }
}

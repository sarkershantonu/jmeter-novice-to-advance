package org.automation.jmeter.exp;

import org.apache.jmeter.engine.JMeterEngine;


/**
 * Created by shantonu on 6/6/16.
 * This org.automation.run the Jmeter via main
 */
public class JmeterTestRunner {

    private static JMeterEngine jmeter = null;

    public static void main(String... args) {
        runLocalJmx();
    }

    public static void runLocalJmx() {
        jmeter = JmeterEngineUtils.initLocalJmeter();
        JmeterEngineUtils.start(jmeter);

    }

    public void runWithJmx(String jmxPath, String propertyPath, String homePath) {
    }


}

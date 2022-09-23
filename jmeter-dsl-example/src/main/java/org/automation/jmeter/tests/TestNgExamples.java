package org.automation.jmeter.tests;


import org.automation.jmeter.tests.scripts.LoadScripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

import java.io.IOException;

public class TestNgExamples {

    @Test
    public void testForThreadGroup() throws IOException {
        TestPlanStats report = LoadScripts.simpleThreadGroupExample().run();
        Assert.assertTrue(report.overall().sampleTimePercentile99().getSeconds()<=5L, "should be less than 5s");

    }
}

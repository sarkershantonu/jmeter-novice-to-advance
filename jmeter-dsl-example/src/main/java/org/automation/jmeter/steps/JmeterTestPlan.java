package org.automation.jmeter.steps;

import org.automation.jmeter.steps.samplers.DefaultHttpSampler;
import us.abstracta.jmeter.javadsl.core.DslTestPlan;
import us.abstracta.jmeter.javadsl.core.threadgroups.BaseThreadGroup;
import us.abstracta.jmeter.javadsl.core.threadgroups.DslDefaultThreadGroup;

import java.time.Duration;
import java.util.Properties;

import static us.abstracta.jmeter.javadsl.JmeterDsl.*;

public class JmeterTestPlan {

    private Properties threadProperties;
    private Properties http;



    public JmeterTestPlan(Properties threadGroupData, Properties httpData) {
        this.threadProperties = threadGroupData;
        this.http = httpData;
    }

    public DslTestPlan getPlanWithIteration() {
        final String name = threadProperties.getProperty("name");
        final int threadCount = Integer.valueOf(threadProperties.getProperty("thread"));
        final int rampup = Integer.valueOf(threadProperties.getProperty("rampup"));
        final String erroraction = threadProperties.getProperty("erroraction");

        return testPlan(
                threadGroup(name, threadCount, rampup,
                        httpSampler(http.getProperty("BASE_UIRL"))));
    }

    private DslTestPlan getPlan(final String name, final int threads, final Duration rampup, final int iteration, final Properties http){
        return testPlan(threadGroup(name, threads, iteration, httpSampler(http.getProperty("BASE_UIRL"))).rampTo(threads,rampup));
    }
    private DslTestPlan getPlan(final String name, final int threads, final Duration rampup, final Duration duration, final int startupDelay, final Properties http){
        return testPlan(threadGroup(name, threads, duration, new DefaultHttpSampler(http).get()).rampTo(threads,rampup));
    }



}

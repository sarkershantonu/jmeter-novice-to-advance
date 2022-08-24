package org.automation.jmeter.steps.threads;

import us.abstracta.jmeter.javadsl.core.threadgroups.defaultthreadgroup.Stage;

import java.time.Duration;

public class UltimateThreadGroupRow {
    private int thread;
    private Duration initDelay;
    private Duration rampup;
    private Duration holdFor;
    private Duration shoutDownIn;

    public UltimateThreadGroupRow(int threadCount, Duration initDelay, Duration rampup, Duration hold, Duration shutdown) {
        this.thread = threadCount;
        this.initDelay = initDelay;
        this.rampup = rampup;
        this.holdFor = hold;
        this.shoutDownIn = shutdown;
    }

    public int getThread() {
        return thread;
    }

    public Duration getInitDelay() {
        return initDelay;
    }

    public Duration getRampup() {
        return rampup;
    }

    public Duration getHoldFor() {
        return holdFor;
    }

    public Duration getShoutDownIn() {
        return shoutDownIn;
    }

    public Stage getStage(){
        return new Stage(getThread(), getHoldFor(), null);
    }
}

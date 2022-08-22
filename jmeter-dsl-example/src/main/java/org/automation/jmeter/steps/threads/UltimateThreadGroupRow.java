package org.automation.jmeter.steps.threads;

import java.time.Duration;

public class UltimateThreadGroupRow {
    private int startThread;
    private Duration initDelay;
    private Duration rampup;
    private Duration holdFor;
    private Duration shoutDownIn;

    public UltimateThreadGroupRow(int startThread, Duration initDelay, Duration rampup, Duration holdFor, Duration shoutDownIn) {
        this.startThread = startThread;
        this.initDelay = initDelay;
        this.rampup = rampup;
        this.holdFor = holdFor;
        this.shoutDownIn = shoutDownIn;
    }

    public int getStartThread() {
        return startThread;
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
}

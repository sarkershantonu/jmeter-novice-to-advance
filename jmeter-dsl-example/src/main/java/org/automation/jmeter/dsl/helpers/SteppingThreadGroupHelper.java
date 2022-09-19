package org.automation.jmeter.dsl.helpers;

import us.abstracta.jmeter.javadsl.core.threadgroups.DslDefaultThreadGroup;

import java.time.Duration;

public class SteppingThreadGroupHelper {

    private int maxThread;
    private Duration firstWait;
    private int thenStartThread;
    private int nextAddThread;
    private Duration every;
    private Duration withRampUp;
    private Duration thenHolding;
    private int stopThread;
    private Duration rateOfStoppingThread;

    public SteppingThreadGroupHelper(int maxThread, Duration firstWait, int thenStartThread, int nextAddThread, Duration every, Duration withRampUp, Duration thenHolding, int stopThread, Duration rateOfStoppingThread) {
        this.maxThread = maxThread;
        this.firstWait = firstWait;
        this.thenStartThread = thenStartThread;
        this.nextAddThread = nextAddThread;
        this.every = every;
        this.withRampUp = withRampUp;
        this.thenHolding = thenHolding;
        this.stopThread = stopThread;
        this.rateOfStoppingThread = rateOfStoppingThread;
    }

    //empty method , todo
    public DslDefaultThreadGroup getThread(){
        return null;
    }
}

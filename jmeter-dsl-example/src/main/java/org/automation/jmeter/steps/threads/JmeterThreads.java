package org.automation.jmeter.steps.threads;

import us.abstracta.jmeter.javadsl.core.threadgroups.BaseThreadGroup;
import us.abstracta.jmeter.javadsl.core.threadgroups.DslDefaultThreadGroup;

import java.time.Duration;

import static us.abstracta.jmeter.javadsl.JmeterDsl.threadGroup;

public class JmeterThreads {
    private final String name;

    public DslDefaultThreadGroup getDefaultThread(int threads, Duration rampup, int loopCount, BaseThreadGroup.ThreadGroupChild... children) {
        return threadGroup(this.name, threads, loopCount, children).holdFor(rampup);
    }

    public DslDefaultThreadGroup getDefaultThread(int threads, Duration rampup, Duration duration, BaseThreadGroup.ThreadGroupChild... children) {
        return threadGroup(this.name, threads, duration, children).holdFor(rampup);
    }
    public DslDefaultThreadGroup getDefaultThread(int threads, Duration rampup, Duration duration,Duration startupDelay, BaseThreadGroup.ThreadGroupChild... children) {
        return threadGroup(this.name, threads, duration, children).holdFor(rampup);
    }

    // SteppingThreadGroup like threads
    public DslDefaultThreadGroup getSteppingThreadGroup(int maxThread,
                                                        Duration startupDelay,
                                                        int startThread,
                                                        int threadIncrease,
                                                        Duration inEvery,
                                                        Duration threadRampup,
                                                        Duration holdThread, BaseThreadGroup.ThreadGroupChild... children) {
        /***
         *   * <pre>{@code
         *    *  threadGroup()
         *    *    .rampTo(10, Duration.ofSeconds(10))
         *    *    .rampTo(5, Duration.ofSeconds(10))
         *    *    .rampToAndHold(20, Duration.ofSeconds(5), Duration.ofSeconds(10))
         *    *    .rampTo(0, Duration.ofSeconds(5))
         *    *    .children(...)
         *    * }
         */
        return null;
    }

    public JmeterThreads(String name, String name1) {

        this.name = name1;
    }


}

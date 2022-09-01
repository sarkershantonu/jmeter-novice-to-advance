package org.automation.jmeter.steps.threads;

import org.automation.jmeter.dsl.model.UltimateThreadGroupRow;
import us.abstracta.jmeter.javadsl.core.threadgroups.BaseThreadGroup;
import us.abstracta.jmeter.javadsl.core.threadgroups.DslDefaultThreadGroup;
import us.abstracta.jmeter.javadsl.core.threadgroups.defaultthreadgroup.Stage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static us.abstracta.jmeter.javadsl.JmeterDsl.threadGroup;

public class JmeterThreads {
    private final String name;

    public DslDefaultThreadGroup getDefaultThread(int threads, Duration rampup, int loopCount, BaseThreadGroup.ThreadGroupChild... children) {
        return threadGroup(this.name, threads, loopCount, children).holdFor(rampup);
    }

    public DslDefaultThreadGroup getDefaultThread(int threads, Duration rampup, Duration duration, BaseThreadGroup.ThreadGroupChild... children) {
        return threadGroup(this.name, threads, duration, children).holdFor(rampup);
    }

    public DslDefaultThreadGroup getDefaultThread(int threads, Duration rampup, Duration duration, Duration startupDelay, BaseThreadGroup.ThreadGroupChild... children) {
        return threadGroup(this.name, threads, duration, children).holdFor(rampup);
    }

    public DslDefaultThreadGroup getDefaultThread(final String name, final int threads, final Duration rampup, final int iteration, BaseThreadGroup.ThreadGroupChild... children){
        return threadGroup(name, threads, iteration,children).rampTo(threads,rampup);
    }

    /***
     * Stepping thread from Jmeter Plugins
     * @param maxThread
     * @param startupDelay
     * @param startThread
     * @param threadIncrease
     * @param inEvery
     * @param threadRampup
     * @param holdThread
     * @param children
     * @return
     */
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

//todo
    public DslDefaultThreadGroup getUltimateThreadGroup(UltimateThreadGroupRow... config) {
        List<Stage> stages = new ArrayList<>();
        for(UltimateThreadGroupRow aRow : config){
            stages.add(aRow.getStage());
        }
        return null;// new DslDefaultThreadGroup(this.name,new UltimateThreadGroupHelper(stages).buildThreadGroup());
    }

    public JmeterThreads(String threadName) {

        this.name = threadName;
    }



}

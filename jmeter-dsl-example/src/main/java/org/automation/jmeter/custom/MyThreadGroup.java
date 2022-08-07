package org.automation.jmeter.custom;

import us.abstracta.jmeter.javadsl.core.threadgroups.DslDefaultThreadGroup;

import java.time.Duration;
import java.util.List;

public class MyThreadGroup extends DslDefaultThreadGroup {
    public MyThreadGroup(String name, int threads, int iterations, List<ThreadGroupChild> children) {
        super(name, threads, iterations, children);
    }

    public MyThreadGroup(String name, int threads, Duration duration, List<ThreadGroupChild> children) {
        super(name, threads, duration, children);
    }

    public MyThreadGroup(String name) {
        super(name);
    }
}

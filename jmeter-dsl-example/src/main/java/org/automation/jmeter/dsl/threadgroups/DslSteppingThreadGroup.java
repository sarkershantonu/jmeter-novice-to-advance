package org.automation.jmeter.dsl.threadgroups;

import org.apache.jmeter.gui.JMeterGUIComponent;
import org.apache.jmeter.threads.AbstractThreadGroup;
import us.abstracta.jmeter.javadsl.core.threadgroups.BaseThreadGroup;

import java.util.List;

public class DslSteppingThreadGroup extends BaseThreadGroup<DslSteppingThreadGroup> {
    protected DslSteppingThreadGroup(String name, Class<? extends JMeterGUIComponent> guiClass, List<ThreadGroupChild> children) {
        super(name, guiClass, children);
    }

    @Override
    protected AbstractThreadGroup buildThreadGroup() {
        return null;
    }

    public DslSteppingThreadGroup saveLoadPlanAsImage(final String imageName){
        return this;
    }
}

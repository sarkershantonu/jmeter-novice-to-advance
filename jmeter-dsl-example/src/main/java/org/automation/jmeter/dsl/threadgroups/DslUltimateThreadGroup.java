package org.automation.jmeter.dsl.threadgroups;

import org.apache.jmeter.gui.JMeterGUIComponent;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.automation.jmeter.dsl.model.UltimateThreadGroupRow;
import us.abstracta.jmeter.javadsl.core.threadgroups.BaseThreadGroup;
import us.abstracta.jmeter.javadsl.core.threadgroups.defaultthreadgroup.Stage;
import us.abstracta.jmeter.javadsl.core.threadgroups.defaultthreadgroup.UltimateThreadGroupHelper;

import java.util.ArrayList;
import java.util.List;

public class DslUltimateThreadGroup extends BaseThreadGroup<DslUltimateThreadGroup> {
    protected DslUltimateThreadGroup(String name, Class<? extends JMeterGUIComponent> guiClass, List<ThreadGroupChild> children) {
        super(name, guiClass, children);
    }

    private List<UltimateThreadGroupRow> config;

    public DslUltimateThreadGroup setLoadPlan(List<UltimateThreadGroupRow> config) {
        this.config = config;
        return this;
    }

    @Override
    protected AbstractThreadGroup buildThreadGroup() {
        List<Stage> stages = new ArrayList<>();
        for(UltimateThreadGroupRow aRow : this.config){
            stages.add(aRow.getStage());
        }
        return new UltimateThreadGroupHelper(stages).buildThreadGroup();
    }

    public DslUltimateThreadGroup saveLoadPlanAsImage(final String imageName){
        return this;
    }
}

package org.automation.jmeter.steps;

import java.util.Properties;

public abstract class JmeterComponent {
    protected final Properties data;

    protected JmeterComponent(Properties data) {
        this.data = data;
    }
}

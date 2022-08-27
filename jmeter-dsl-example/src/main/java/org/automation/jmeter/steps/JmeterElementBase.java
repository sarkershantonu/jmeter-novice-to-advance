package org.automation.jmeter.steps;

import java.util.Properties;

public abstract class JmeterElementBase {
    
    private final String name; 
    private final String comments;
    public final Properties data;

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public Properties getData() {
        return data;
    }

    public JmeterElementBase(String name, String comments, Properties data) {
        this.name = name;
        this.comments = comments;
        this.data = data;
    }
    
}

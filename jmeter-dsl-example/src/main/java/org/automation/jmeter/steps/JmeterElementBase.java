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

    public JmeterElementBase(Properties data) {
        this.data = data;
        this.comments = data.getProperty("name");
        this.name =  data.getProperty("comments");
    }
    
}

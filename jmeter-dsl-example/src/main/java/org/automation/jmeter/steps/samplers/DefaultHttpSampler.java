package org.automation.jmeter.steps.samplers;

import org.automation.jmeter.steps.JmeterElementBase;
import us.abstracta.jmeter.javadsl.http.DslHttpSampler;

import java.util.Properties;

import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;

public class DefaultHttpSampler extends JmeterElementBase {

    public DefaultHttpSampler(String name, String comments, Properties data) {
        super(name, comments, data);
    }

    public DslHttpSampler get(){
        return httpSampler(data.getProperty("BASE_URL"));
    }
}

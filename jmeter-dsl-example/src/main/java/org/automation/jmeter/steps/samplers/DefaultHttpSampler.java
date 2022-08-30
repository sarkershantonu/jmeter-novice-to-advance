package org.automation.jmeter.steps.samplers;

import org.automation.jmeter.steps.JmeterElementBase;
import us.abstracta.jmeter.javadsl.http.DslHttpSampler;

import java.util.Properties;

import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;

public class DefaultHttpSampler extends JmeterElementBase {

    public DefaultHttpSampler(Properties data) {
        super( data);
    }

    public DslHttpSampler get(){
        return httpSampler(data.getProperty("BASE_URL"));
    }
}

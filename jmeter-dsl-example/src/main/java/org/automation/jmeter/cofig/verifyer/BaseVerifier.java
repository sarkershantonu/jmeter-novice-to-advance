package org.automation.jmeter.cofig.verifyer;

import org.automation.jmeter.cofig.ContextLoader;
import org.automation.jmeter.core.exceptions.TestDataLoadingException;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static org.automation.jmeter.cofig.verifyer.Verifier.isBlank;

public abstract class BaseVerifier {
    private final String data;
    public final Properties values;

    public BaseVerifier(String data) {
        this.data = data;
        this.values = load();
    }

    public final Properties load() {
        try {
            return new ContextLoader(this.data).loadFromFolder("test-data");
        } catch (IOException e) {
            throw new TestDataLoadingException("failed to load data file from " + this.data, e);
        }
    }

    public boolean isNameIsNotBlank() {
        return !isBlank(values.getProperty("name").trim());
    }

    public String getDataValue(final String propertyName){
        return values.getProperty(propertyName);
    }

    public void printValues(){
        Map map = (Map)values;
        for(Object key : map.keySet()){
            System.out.println((String)key + ":"+(String) map.get(key));
        }
    }
}

package org.automation.jmeter.cofig;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Shantonu Sarker on 5/27/2022
 */
public class TestConfig {
    public static String protocol;
    public static String HOST;
    public static Properties httpData;

    static {
        try {
            httpData = new ContextLoader("http.ini").loadFromFolder("test-data");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

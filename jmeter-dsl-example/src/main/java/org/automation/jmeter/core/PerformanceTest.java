package org.automation.jmeter.core;

import java.time.Instant;
import java.util.Properties;

/**
 * @author Shantonu Sarker on 5/26/2022
 */
public abstract class PerformanceTest {
    final String jjtl_folder="target/";
    public final String getJtlFolderName(){
        return jjtl_folder+"demoExecution"+ Instant.now().toString().replace(":","_")+".jtl";
    }
    protected Properties httpSamplerProperties;
    protected Properties ThreadGroupProperties;
}

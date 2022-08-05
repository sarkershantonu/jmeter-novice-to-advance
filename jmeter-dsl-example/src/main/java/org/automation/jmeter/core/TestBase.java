package org.automation.jmeter.core;

import java.time.Instant;

/**
 * @author Shantonu Sarker on 5/26/2022
 */
public abstract class TestBase {
    final String jjtl_folder="target/";
    public final String getJtlFolderName(){
        return jjtl_folder+"demoExecution"+ Instant.now().toString().replace(":","_")+".jtl";
    }
}

package org.automation.jmeter.exp;

import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;
import java.io.IOException;

/**
 * Created by shantonu on 6/13/16.
 */
public class JmeterEngineUtils {

    public static void start(JMeterEngine engine, HashTree jmx) {
        try {
            engine.configure(jmx);
            engine.runTest();
        } catch (JMeterEngineException e) {
            e.printStackTrace();
        }
    }
    public static void start(JMeterEngine engine) {
        try {
            engine.runTest();
        } catch (JMeterEngineException e) {
            e.printStackTrace();
        }
    }

    public static void stop(JMeterEngine engine) {
        try {
            engine.stopTest(true);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static JMeterEngine initLocalJmeter(){
        String home = System.getProperty("user.dir")+"/src/main/resources";
        System.out.println(home);
        return initLocalJmeter(home+"/bin/jmeter.properties",home);
    }
    public static JMeterEngine initLocalJmeter(String propertyPath, String homePath){
        StandardJMeterEngine engine = new StandardJMeterEngine();
        if(homePath.equals(null)){
            homePath= System.getProperty("user.dir"+"/src/main/resources");
        }
        if(propertyPath.equals(null)){
            propertyPath = homePath+ File.separator+"bin"+ File.separator+"jmeter.properties";
        }

        JMeterUtils.loadJMeterProperties(propertyPath);
        JMeterUtils.setJMeterHome(homePath);
        JMeterUtils.initLogging();
        JMeterUtils.initLocale();
        try {
            SaveService.loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return engine;
    }

    public static JMeterEngine loadJmx(JMeterEngine engine, String path) throws IOException {
        //FileInputStream fis = new FileInputStream(new File(path)); => old way, you need to close
        HashTree jmx =  SaveService.loadTree(new File(path));
        engine.configure(jmx);
        return engine;
    }
}

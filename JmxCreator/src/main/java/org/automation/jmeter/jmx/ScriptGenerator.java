package org.automation.jmeter.jmx;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.automation.jmeter.models.Variable;

/**
 * Created by shantonu on 6/12/16.
 * TODO
 */
public class ScriptGenerator {
    private static HashTree jmxTree = null;
    public static HashTree addResultINJMX(HashTree jmx, String jtlPath){
        Summariser summary = new Summariser();
        String name = JMeterUtils.getPropDefault("summriser.name", "summary");
        ResultCollector rc = new ResultCollector(summary);
        rc.setFilename(jtlPath);
        jmx.add(jmx.getArray()[0],rc);
        return jmx;
    }
    private static HashTree getTestPlan() {
        if(jmxTree==null){
            jmxTree = new HashTree();
        }
        return jmxTree;
    }
    public HashTree createTestPlan(String name){
        HashTree testPlanTree = getTestPlan();
        TestPlan testPlan = new TestPlan(name);
        jmxTree.add("testPlan", testPlan);
        //jmxTree.add("loopController",getLoopController("Loop",5));
        jmxTree.add("threadGroup",getThreadGroup("MyThreadGroup",20, 600, getLoopController("Loop",200)));
        jmxTree.add("httpSampler",getAnHttp("Google", "google.com"));
        return testPlanTree;

    }
    private HTTPSampler getAnHttp(String name, String domain){
        HTTPSampler http = new HTTPSampler();
        http.setName(name);
        http.setDomain(domain);
        http.setPort(80);
        http.setPath("/");
        http.setMethod("GET");
        return http;
    }
    private LoopController getLoopController(String name, int count){
        LoopController loop = new LoopController();
        loop.setName(name);
        loop.setLoops(count);
        loop.addTestElement(getAnHttp("AnHttpRequest","google.com"));
        loop.setFirst(true);
        loop.initialize();
        return loop;
    }
    private AbstractThreadGroup getThreadGroup(String name, int thread, int rampup, LoopController loop){
        ThreadGroup td = new ThreadGroup();
        td.setNumThreads(thread);
        td.setRampUp(rampup);
        td.setSamplerController(loop);

        return td;
    }
    public static TestPlan addTestPlan(String name){
        return  new TestPlan(name);
    }

    public static HashTree initScript(HashTree jmx, TestPlan... testPlan){
        jmx.add(addTestPlan("createdFromIDE"));
        jmx.add("loop", testPlan[0]);
        return jmx;
    }

    // NEW items, old will be refactored , need to support jmeter + blazemeter plugins too
    private static TestPlan getTestPlan(String name, String comments, boolean isConsecutively, boolean isTearDownAfterShutdown, String classpath, Variable... values){
        TestPlan tp = new TestPlan();

        return tp;
    }
    private static AbstractThreadGroup getThreadGroup(){
        return null;
    }
}

package org.automation.jmeter.exp;

import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.functions.RegexFunction;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

/**
 * Created by shantonu on 7/30/16.
 */
public class RegularExpressionExtractorExamples implements In_JSR223_Java{


    @Override
    public void writeInJSRElement() {



    }

    public void viaFunction(){
        RegexFunction regix = new RegexFunction();
        SampleResult result = new SampleResult();
        Sampler sampler = new HTTPSampler();//this part wont be in there as you will get current samperls
        String resultRegix;
        try {
            resultRegix = regix.execute(result,sampler);
        } catch (InvalidVariableException e) {
            e.printStackTrace();
        }
    }
}

package org.automation.jmeter.cofig.verifyer;

import static org.automation.jmeter.cofig.verifyer.Verifier.isBlank;
import static org.automation.jmeter.cofig.verifyer.Verifier.isInteger;

public class VerifyDefaultThreadGroup extends BaseVerifier{
    public VerifyDefaultThreadGroup(String data) {
        super(data);
    }

    public boolean isValidThreadGroup(){
        return isNameIsNotBlank()||isThreadNumberPresent()||isRampupPresent()||isValidLoopSettings();
    }

    private boolean isValidLoopSettings() {
        String loop  = getDataValue("loop");
        boolean isinfinite  = Boolean.getBoolean(getDataValue("isinfinite"));
        if(isinfinite){
            return isBlank(loop);
        }else
            return !isBlank(loop);
    }

    private boolean isRampupPresent() {
        return isInteger(getDataValue("rampup"));
    }

    private boolean isThreadNumberPresent() {
        return  isInteger(getDataValue("thread"));
    }

    //todo
    private boolean isValidSAmplerErrorAction(){
        return true;
    }
}

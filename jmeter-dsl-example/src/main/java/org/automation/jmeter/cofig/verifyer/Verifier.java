package org.automation.jmeter.cofig.verifyer;

class Verifier {
    public static boolean isInteger(final String value){
        return value.matches("\\d");
    }
    public static boolean isBlank(final String value){
        return value.trim() == "" || null == value;
    }
}

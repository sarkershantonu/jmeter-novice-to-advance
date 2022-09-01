package org.automation.jmeter.dsl.erros;

public class ThreadCountException extends IllegalArgumentException{
    public ThreadCountException(String s) {
        super("Threads count must be >=1");
    }
}

package org.automation.jmeter.dsl.erros;

public class ThreadStateException extends IllegalStateException{
    public ThreadStateException() {
        super( "Ramping up/down after holding for iterations is not supported. "
                + "If you used constructor with iterations, consider using "
                + "threadGroup().rampTo(X, Y).holdForIterations(Z) instead");
    }
}

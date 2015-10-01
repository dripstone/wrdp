package org.zhiyan.core.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1403241379992869500L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable exception) {
        super(message);
        embeddedException = exception;
    }

    @Override
    public Throwable getCause() {
        return embeddedException;
    }

    @Override
    public void printStackTrace(PrintStream out) {
        if (out != null)
            synchronized (out) {
                super.printStackTrace(out);
                Throwable t = getCause();
                if (t != null) {
                    out.print("Caused by: ");
                    t.printStackTrace(out);
                }
            }
    }

    @Override
    public void printStackTrace(PrintWriter out) {
        if (out != null)
            synchronized (out) {
                super.printStackTrace(out);
                Throwable t = getCause();
                if (t != null) {
                    out.print("Caused by: ");
                    t.printStackTrace(out);
                }
            }
    }

    @Override
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override
    public String toString() {
        return "ServiceException(" + super.toString() + "), root cause("
                + embeddedException + ")";
    }

    protected Throwable embeddedException;
}

package com.example.loginapplication.Bean;

/**
 * Created by Administrator on 2017/11/28 0028.
 */

public class Path {

    /**
     * body : null
     * success : false
     * failureMessage : null
     * failureCode : NOT_AUTHENTICATED
     */

    private Object body;
    private boolean success;
    private Object failureMessage;
    private String failureCode;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(Object failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }
}

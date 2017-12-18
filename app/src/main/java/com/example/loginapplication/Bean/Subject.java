package com.example.loginapplication.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */

public class Subject {
    /**
     * body : [{"name":"語文","id":null},{"name":"社會","id":null}]
     * success : true
     * failureMessage : null
     * failureCode : null
     */

    private boolean success;
    private Object failureMessage;
    private Object failureCode;
    private List<BodyBean> body;

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

    public Object getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(Object failureCode) {
        this.failureCode = failureCode;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * name : 語文
         * id : null
         */

        private String name;
        private Object id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }
    }
}

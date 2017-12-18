package com.example.loginapplication.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */

public class Kemu {
    /**
     * body : [{"size":792576,"version":1,"versionId":1815,"name":"1617-S1-M2-Vocabulary.ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2742,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/1617-S1-M2-Vocabulary.ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:48","createdTime":"2017/09/07 22:16:48","operator":"許詠琪","creator":"許詠琪"},{"size":52736,"version":1,"versionId":1816,"name":"Outline for the test 1st module 1.doc","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2743,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/Outline for the test 1st module 1.doc","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:48","createdTime":"2017/09/07 22:16:48","operator":"許詠琪","creator":"許詠琪"},{"size":1106432,"version":1,"versionId":1817,"name":"Present Continuous Tense.ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2744,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/Present Continuous Tense.ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:48","createdTime":"2017/09/07 22:16:48","operator":"許詠琪","creator":"許詠琪"},{"size":304128,"version":1,"versionId":1818,"name":"S1-Modul 1-worksheet-Grammar..ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2745,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/S1-Modul 1-worksheet-Grammar..ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:49","createdTime":"2017/09/07 22:16:49","operator":"許詠琪","creator":"許詠琪"},{"size":86528,"version":1,"versionId":1819,"name":"S1-Modul 1-worksheet-first English letter.ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2746,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/S1-Modul 1-worksheet-first English letter.ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:49","createdTime":"2017/09/07 22:16:49","operator":"許詠琪","creator":"許詠琪"},{"size":33792,"version":1,"versionId":1820,"name":"Sentences making.ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2747,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/Sentences making.ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:49","createdTime":"2017/09/07 22:16:49","operator":"許詠琪","creator":"許詠琪"},{"size":345088,"version":1,"versionId":1821,"name":"Unit 1 Simple present tense statement.ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2748,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/Unit 1 Simple present tense statement.ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:49","createdTime":"2017/09/07 22:16:49","operator":"許詠琪","creator":"許詠琪"},{"size":663552,"version":1,"versionId":1822,"name":"Unit 2 Simple present Tense questions.ppt","permissions":["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"],"id":2749,"type":"DOCUMENT","path":"/教學園地//2017年/科組/科組/英文/Unit 2 Simple present Tense questions.ppt","description":null,"status":"ACTIVE","parentFolderId":2741,"operationTime":"2017/09/07 22:16:50","createdTime":"2017/09/07 22:16:50","operator":"許詠琪","creator":"許詠琪"}]
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
         * size : 792576
         * version : 1.0
         * versionId : 1815
         * name : 1617-S1-M2-Vocabulary.ppt
         * permissions : ["RESOURCE_DELETE","RESOURCE_DOWNLOAD","RESOURCE_READ","RESOURCE_UPDATE"]
         * id : 2742
         * type : DOCUMENT
         * path : /教學園地//2017年/科組/科組/英文/1617-S1-M2-Vocabulary.ppt
         * description : null
         * status : ACTIVE
         * parentFolderId : 2741
         * operationTime : 2017/09/07 22:16:48
         * createdTime : 2017/09/07 22:16:48
         * operator : 許詠琪
         * creator : 許詠琪
         */

        private int size;
        private double version;
        private int versionId;
        private String name;
        private int id;
        private String type;
        private String path;
        private Object description;
        private String status;
        private int parentFolderId;
        private String operationTime;
        private String createdTime;
        private String operator;
        private String creator;
        private List<String> permissions;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public double getVersion() {
            return version;
        }

        public void setVersion(double version) {
            this.version = version;
        }

        public int getVersionId() {
            return versionId;
        }

        public void setVersionId(int versionId) {
            this.versionId = versionId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getParentFolderId() {
            return parentFolderId;
        }

        public void setParentFolderId(int parentFolderId) {
            this.parentFolderId = parentFolderId;
        }

        public String getOperationTime() {
            return operationTime;
        }

        public void setOperationTime(String operationTime) {
            this.operationTime = operationTime;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public List<String> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }
    }
}

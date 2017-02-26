package com.millinch.core.domain;

/**
 * For http response
 *
 * @author John Zhang
 */
public class ResponseModel {

    private boolean ok;

    private String message;

    private Object body;

    public boolean isOk() {
        return ok;
    }

    public String getMessage() {
        return message;
    }

    public Object getBody() {
        return body;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ResponseModel model = new ResponseModel();

        public Builder ok() {
            model.ok = true;
            return this;
        }

        public Builder ok(boolean isOk) {
            model.ok = isOk;
            return this;
        }

        public Builder failed() {
            model.ok = false;
            return this;
        }

        public Builder message(String message) {
            model.message = message;
            return this;
        }
        public Builder body(Object body) {
            model.body = body;
            return this;
        }

        public ResponseModel done() {
            return model;
        }
    }

}

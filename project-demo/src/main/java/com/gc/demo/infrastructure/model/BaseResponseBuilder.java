package com.gc.demo.infrastructure.model;

public class BaseResponseBuilder {
    public static class Builder<T> {
        private BaseResponse<T> message;

        public Builder(boolean success) {
            message = new BaseResponse<T>();
            message.setStatus(success ? BaseResponse.Code.OK : BaseResponse.Code.ERROR);
        }

        public Builder() {
            message = new BaseResponse<T>();
        }

        public Builder<T> setStatus(int status) {
            message.setStatus(status);
            return this;
        }

        public Builder<T> setData(T data) {
            message.setData(data);
            return this;
        }

        public Builder<T> setError(String error) {
            message.setMessage(error);
            return this;
        }

        public BaseResponse<T> builder() {
            return message;
        }
    }

}

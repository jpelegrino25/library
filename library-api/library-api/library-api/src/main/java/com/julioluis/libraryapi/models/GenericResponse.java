package com.julioluis.libraryapi.models;

import java.util.List;

public class GenericResponse<T> {

    private T result;
    private boolean success;
    private String message;



    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "result=" + result +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}

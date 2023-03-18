package com.devsuperior.bds02.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String message;
    private String error;
    private List<Map<String, String>> fieldErrors;
    private String path;

    public StandardError(){}

    public StandardError(Instant timestamp, Integer status, String message, String error, List<Map<String, String>> fieldErrors, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.fieldErrors = fieldErrors;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Map<String, String>> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<Map<String, String>> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

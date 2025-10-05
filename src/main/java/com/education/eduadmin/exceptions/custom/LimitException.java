package com.education.eduadmin.exceptions.custom;

public class LimitException extends RuntimeException {
    public LimitException(String message) {
        super(message);
    }
}

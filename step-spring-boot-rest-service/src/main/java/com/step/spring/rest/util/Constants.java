package com.step.spring.rest.util;

public class Constants {
    public static final String MESSAGE_SUCCESS = "Success";

    public static final String MESSAGE_ERROR_INTERNAL = "Internal error";
    public static final String MESSAGE_ERROR_NOT_FOUND = "Student with given id not found";
    public static final String MESSAGE_ERROR_FIELDS_NOT_VALID = "One or more fields not validated";

    public static int codeOf(String message) {
        switch (message) {
            case MESSAGE_SUCCESS:
                return 1;
            case MESSAGE_ERROR_NOT_FOUND:
                return 2;
            case MESSAGE_ERROR_FIELDS_NOT_VALID:
                return 3;
            case MESSAGE_ERROR_INTERNAL:
                return 0;
            default:
                return 0;
        }
    }


}

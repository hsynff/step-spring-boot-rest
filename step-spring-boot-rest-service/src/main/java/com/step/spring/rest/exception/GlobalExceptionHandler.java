package com.step.spring.rest.exception;

import com.step.spring.rest.model.Status;
import com.step.spring.rest.model.response.GlobalResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResp> handleAllExceptions(Exception e){
        GlobalResp response = new GlobalResp();
        Status status = new Status(e.getMessage());
        response.setStatus(status);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

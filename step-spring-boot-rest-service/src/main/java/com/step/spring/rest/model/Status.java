package com.step.spring.rest.model;

import com.step.spring.rest.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private int code;
    private String message;

    public Status(String message){
        this.message = message;
        this.code = Constants.codeOf(message);
    }

    public static Status success(){
        return new Status(Constants.MESSAGE_SUCCESS);
    }
}

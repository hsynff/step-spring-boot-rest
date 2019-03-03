package com.step.spring.rest.model.response;

import com.step.spring.rest.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResp {
    private Status status;
}

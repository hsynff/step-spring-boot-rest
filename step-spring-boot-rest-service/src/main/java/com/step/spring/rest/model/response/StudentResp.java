package com.step.spring.rest.model.response;

import com.step.spring.rest.model.Status;
import com.step.spring.rest.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResp {
    private Status status;
    private Student student;
}

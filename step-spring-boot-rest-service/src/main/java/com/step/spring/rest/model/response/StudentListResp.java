package com.step.spring.rest.model.response;

import com.step.spring.rest.model.Status;
import com.step.spring.rest.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentListResp {
    private Status status;
    private List<Student> students;
}

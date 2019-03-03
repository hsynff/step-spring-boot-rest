package com.step.spring.rest.model;

import com.step.spring.rest.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    @NotNull(message = Constants.MESSAGE_ERROR_FIELDS_NOT_VALID)
    @NotEmpty(message = Constants.MESSAGE_ERROR_FIELDS_NOT_VALID)
    private String name;
    @NotNull(message = Constants.MESSAGE_ERROR_FIELDS_NOT_VALID)
    @NotEmpty(message = Constants.MESSAGE_ERROR_FIELDS_NOT_VALID)
    private String course;
}

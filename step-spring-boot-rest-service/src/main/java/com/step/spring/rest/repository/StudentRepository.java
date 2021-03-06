package com.step.spring.rest.repository;

import com.step.spring.rest.exception.ServiceException;
import com.step.spring.rest.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudent();
    Student getStudentById(int id) throws ServiceException;
    Student deleteStudent(int id) throws ServiceException;
    Student addStudent(Student student);
    void updateStudent(Student student) throws ServiceException;
}

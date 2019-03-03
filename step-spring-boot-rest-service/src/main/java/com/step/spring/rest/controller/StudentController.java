package com.step.spring.rest.controller;

import com.step.spring.rest.exception.ServiceException;
import com.step.spring.rest.model.Status;
import com.step.spring.rest.model.Student;
import com.step.spring.rest.model.response.GlobalResp;
import com.step.spring.rest.model.response.StudentListResp;
import com.step.spring.rest.model.response.StudentResp;
import com.step.spring.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class exposes REST endpoint for student resource
 *
 * @author Joshgun
 * @author Elvin
 * */
@RestController
public class StudentController {

    private StudentService studentService;

    /**
     * Creates StudentController with {@link StudentService} object
     *
     * @param studentService StudentService object
     * */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Gets all students
     *
     * @return StudentListResp with Status and Student list objects.
     * */
    @GetMapping("/students")
    public StudentListResp getAllStudent(){
        List<Student> list = studentService.getAllStudent();
        StudentListResp response = new StudentListResp();
        Status status = Status.success();
        response.setStatus(status);
        response.setStudents(list);

        return response;
    }

    /**
     * Gets {@link Student} resource with given id.
     *
     * @param id Student id.
     * @return StudentResp object with Status and Student object.
     * @throws ServiceException when student with given id not found.
     * */
    @GetMapping("/students/{id}")
    public StudentResp getStudentById(@PathVariable("id") int id) throws ServiceException {
        Student student = studentService.getStudentById(id);

        StudentResp response = new StudentResp();
        Status status = Status.success();
        response.setStatus(status);
        response.setStudent(student);

        return response;
    }

    /**
     * Deletes {@link Student} resource with gven id.
     *
     * @param id Student id.
     * @return StudentResp object with Status and deleted Student object.
     * @throws ServiceException when student with given id not found.
     * */
    @DeleteMapping("/students/{id}")
    public StudentResp deleteStudent(@PathVariable("id") int id) throws ServiceException {
        Student deletedStudent = studentService.deleteStudent(id);

        StudentResp response = new StudentResp();
        Status status = Status.success();
        response.setStatus(status);
        response.setStudent(deletedStudent);

        return response;
    }

    /**
     * Updates {@link Student} resource with given id.
     *
     * @param id Student id.
     * @param student Student fields being updated.
     * @return GlobalResp entity with only {@link Status}
     * @throws ServiceException when student with given id not found or one or more Student fields are not valid.
     * */
    @PutMapping("/students/{id}")
    public GlobalResp updateStudent(@PathVariable("id") int id, @Valid @RequestBody Student student, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()){
            throw new ServiceException(bindingResult.getFieldError().getDefaultMessage());
        }
        student.setId(id);

        studentService.updateStudent(student);

        GlobalResp response = new GlobalResp();
        Status status = Status.success();

        response.setStatus(status);
        return response;
    }

    /**
     * Adds student.
     *
     * @param student {@link Student} object being added.
     * @param bindingResult {@link BindingResult} object.
     * @return StudentResp object with Status and added Student object.
     * @throws ServiceException when one or more Student fields are not valid.
     * */
    @PostMapping("/students")
    public StudentResp addStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()){
            throw new ServiceException(bindingResult.getFieldError().getDefaultMessage());
        }

        Student newStudent = studentService.addStudent(student);

        StudentResp response = new StudentResp();
        Status status = Status.success();
        response.setStatus(status);
        response.setStudent(newStudent);

        return response;
    }


}

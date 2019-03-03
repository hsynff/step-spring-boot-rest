package com.step.spring.rest.service;

import com.step.spring.rest.exception.ServiceException;
import com.step.spring.rest.model.Student;
import com.step.spring.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) throws ServiceException {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student deleteStudent(int id) throws ServiceException {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) throws ServiceException {
        studentRepository.updateStudent(student);
    }
}

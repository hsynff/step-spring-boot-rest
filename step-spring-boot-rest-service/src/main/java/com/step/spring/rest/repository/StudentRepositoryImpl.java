package com.step.spring.rest.repository;

import com.step.spring.rest.exception.ServiceException;
import com.step.spring.rest.model.Student;
import com.step.spring.rest.util.Constants;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static final List<Student> data;
    public static int nextId = 5;

    static {
        data = new ArrayList<>();
        data.add(new Student(1, "John", "Java"));
        data.add(new Student(2, "Merry", "C#"));
        data.add(new Student(3, "Memmed", "Java"));
        data.add(new Student(4, "Nigar", "Web"));
    }

    @Override
    public List<Student> getAllStudent() {
        return data;
    }

    @Override
    public Student getStudentById(int id) throws ServiceException {
        return data
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(Constants.MESSAGE_ERROR_NOT_FOUND));
    }

    @Override
    public Student deleteStudent(int id) throws ServiceException {
        Student deletedStudent = getStudentById(id);
        data.removeIf(s -> s.getId() == id);
        return deletedStudent;
    }

    @Override
    public Student addStudent(Student student) {
        student.setId(nextId++);
        data.add(student);
        return student;
    }

    @Override
    public void updateStudent(Student student) throws ServiceException {
        Student oldStudent = getStudentById(student.getId());
        oldStudent.setCourse(student.getCourse());
        oldStudent.setName(student.getName());
    }
}

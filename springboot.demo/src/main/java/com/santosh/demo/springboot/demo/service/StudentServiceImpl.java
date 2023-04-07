package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Student;
import com.santosh.demo.springboot.demo.repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}

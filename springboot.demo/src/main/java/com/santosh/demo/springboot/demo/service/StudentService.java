package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface StudentService {
    public Student save(Student student);
}

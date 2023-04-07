package com.santosh.demo.springboot.demo.controller;

import com.santosh.demo.springboot.demo.entity.Student;
import com.santosh.demo.springboot.demo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {
    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping("/student")
    public Student save(@RequestBody @Valid Student student) throws Exception {
        Student student1 = studentService.save(student);
        return student1;

    }
}

package com.santosh.demo.springboot.demo.controller;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/api/v1/create")
    public Department create(@RequestBody Department department) {
        Department department1 = departmentService.save(department);
        return department1;
    }

    @GetMapping("/list")
    public List<Department> list() {
        List<Department> departmentList = departmentService.findAll();
        return departmentList;
    }

    @GetMapping("/list/{id}")
    public Department getById(@PathVariable("id") Long departmentId) {
        Department department = departmentService.getById(departmentId);
        return department;
    }
}

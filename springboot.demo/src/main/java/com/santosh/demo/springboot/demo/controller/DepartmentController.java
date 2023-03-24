package com.santosh.demo.springboot.demo.controller;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/api/v1/create")
    public Department create(@Valid @RequestBody Department department) {
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

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return  "department delete successfully";
    }

    @PutMapping("/update/{id}")
    public Department update(@PathVariable("id") Long id,@Valid @RequestBody Department data){
      Department department =  departmentService.update(id,data);
      return department;
    }

    @GetMapping("/getByName")
    public Department getByName(@RequestBody Map<String,String> name){
        Department department = departmentService.getByName(name.get("name"));
        return department;
    }
}

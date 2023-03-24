package com.santosh.demo.springboot.demo.controller;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.error.DepartmentNotFound;
import com.santosh.demo.springboot.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    //can set where to log i.e in file , console,rolling policies ==> configuration can be done in properties files
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/api/v1/create")
    public Department create(@Valid @RequestBody Department department) {
        Department department1 = departmentService.save(department);
        logger.info("inside save method");
        return department1;
    }

    @GetMapping("/list")
    public List<Department> list() {
        List<Department> departmentList = departmentService.findAll();
        logger.info("inside list");
        return departmentList;
    }

    @GetMapping("/list/{id}")
    public Department getById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
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

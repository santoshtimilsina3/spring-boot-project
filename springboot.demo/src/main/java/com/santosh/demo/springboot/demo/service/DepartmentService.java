package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.error.DepartmentNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface DepartmentService {

    public Department save(Department department);

    public List<Department> findAll();

    public Department getById(Long id) throws DepartmentNotFound;

    public void deleteDepartmentById(Long departmentId);


    Department update(Long id, Department data);

    Department getByName(String name);
}

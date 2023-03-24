package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {

    public Department save(Department department);

    public List<Department> findAll();

    public Department getById(Long id);

}

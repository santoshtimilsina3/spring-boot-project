package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.error.DepartmentNotFound;
import com.santosh.demo.springboot.demo.repository.DepartmentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Primary
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    DepartmentServiceImpl(DepartmentRepository repository) {
        this.departmentRepository = repository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) throws DepartmentNotFound {
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFound("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department update(Long id, Department params) {
        Department department = departmentRepository.findById(id).get();
        if (Objects.nonNull(params.getName())) {
            department.setName(params.getName());
        }
        if (Objects.nonNull(params.getAddress() != null)) {
            department.setAddress(params.getAddress());
        }
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department getByName(String name) {
        Department department = departmentRepository.findDepartmentByName(name);
        return department;
    }

}

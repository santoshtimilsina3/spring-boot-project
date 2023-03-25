package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.error.DepartmentNotFound;
import com.santosh.demo.springboot.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    public DepartmentService departmentService;
    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L).name("test").build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.of(Optional.ofNullable(department).get()));
    }


    @Test
    public void get_departmentById() throws DepartmentNotFound {
        Long id = 1L;
        Department result = departmentService.getById(id);
        assertEquals(id, result.getDepartmentId());

    }
}
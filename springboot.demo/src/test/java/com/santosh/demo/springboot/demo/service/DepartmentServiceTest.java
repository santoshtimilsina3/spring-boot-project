package com.santosh.demo.springboot.demo.service;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("IT").address("pokhara").code("220").build();

        Mockito.when(departmentRepository.findDepartmentByName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("get Data based on department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.getByName(departmentName);
        assertEquals(departmentName, found.getName());

    }

}
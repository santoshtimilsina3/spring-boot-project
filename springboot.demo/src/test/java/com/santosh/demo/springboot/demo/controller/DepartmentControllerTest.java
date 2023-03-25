package com.santosh.demo.springboot.demo.controller;

import com.santosh.demo.springboot.demo.entity.Department;
import com.santosh.demo.springboot.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .name("It").address("pkr").departmentId(1L).build();
    }

    @Test
    void create() throws Exception {
        Department departmentInput = Department.builder()
                .name("It").address("pkr").build();
        Mockito.when(departmentService.save(departmentInput)).thenReturn(department);
        mockMvc.perform(post("/api/v1/department/create").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"It\",\n" +
                        "    \"address\":\"pkr\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void getById() {
    }
}
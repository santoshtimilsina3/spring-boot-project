package com.santosh.demo.springboot.demo;

import com.santosh.demo.springboot.demo.controller.StudentController;
import com.santosh.demo.springboot.demo.entity.Student;
import com.santosh.demo.springboot.demo.repository.StudentRepository;
import com.santosh.demo.springboot.demo.service.StudentService;
import com.santosh.demo.springboot.demo.service.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

		Student student1 = new Student();
		student1.setStudent_id(1L);
		student1.setName("Ram");
		student1.setAddress("Pokhara");
		student1.setPhoneNumber(9868158416L);


	}

}

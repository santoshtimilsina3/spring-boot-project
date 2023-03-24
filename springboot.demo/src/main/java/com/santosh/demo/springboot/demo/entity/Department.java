package com.santosh.demo.springboot.demo.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "please add department name")
    @Length(max = 5,min = 0)
    private String name;
    /*
    Validation constraints in hibernate
    @Email
    @Positive
    @Negative
    @Future
    @Past
    @PastOrPresent
    @Pattern(regexp = "^[a-zA-Z0-9]",message = "Length must be 3")*/
    private String address;
    private String code;

    public Department(Long departmentId, String name, String address, String code) {
        this.departmentId = departmentId;
        this.name = name;
        this.address = address;
        this.code = code;
    }

    public Department() {

    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

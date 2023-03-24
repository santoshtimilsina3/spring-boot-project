package com.santosh.demo.springboot.demo.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

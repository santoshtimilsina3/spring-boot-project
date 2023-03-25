package com.example.springdatajpa.repository;

import com.example.springdatajpa.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*JPQL QUERIES
    They are queried on the basis of class Name not the database table name
    here in database has table name tbl_student but we are querying on the basis
    of the Student

    here =?1 represent the first parameter that is passed in the method
    * */
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    //Native Queries
    @Query(
            value = "select * from tbl_student s where s.emailId = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String email);


    //Native Named parameters
    @Query(value = "select * from tbl_student s where s.emailId =:emailId",
            nativeQuery = true)
    Student getStudentByEmailParam(@Param("emailId") String emailId);

    //For updating the data on the database we need to configure this
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name =?1 where email_address= ?2",
            nativeQuery = true)
    int updateStudentFirstNameByEmailId(String firstName, String emailAddress);

}
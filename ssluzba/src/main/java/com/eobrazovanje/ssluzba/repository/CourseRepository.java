package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

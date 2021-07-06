package com.rest.in28minutes.restapiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.in28minutes.restapiexample.data.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}

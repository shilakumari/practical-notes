package com.rest.in28minutes.restapiexample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.in28minutes.restapiexample.data.Course;
import com.rest.in28minutes.restapiexample.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository repository;

	// GET - Retrieve information (/courses, /courses/1)
	// POST - Create a new resource (/courses)
	// PUT - Update/Replace a resource (/courses/1)
	// PATCH - Update a part of the resource (/courses/1)
	// DELETE - Delete a resource (/courses/1)

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourseDetails(@PathVariable long courseId) {
		Optional<Course> course = repository.findById(courseId);
		if (course.isEmpty()) {
			throw new RuntimeException("Course not found with id " + courseId);
		}
		return course.get();
	}

	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) {
		return repository.save(course);
	}

	@PutMapping("/course/{courseId}")
	public Course updateCourse(@PathVariable long courseId, @RequestBody Course course) {
		return repository.save(course);
	}

	@DeleteMapping("/course/{courseId}")
	public void updateCourse(@PathVariable long courseId) {
		repository.deleteById(courseId);
	}
}

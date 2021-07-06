package com.rest.in28minutes.restapiexample.data;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;

	// @Column(name = "course_name")
	private String name;
	private String author;

	public Course() {
	}

	public Course(long courseId, String name, String author) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.author = author;

	}

	public Course(String name, String author) {
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", author=" + author + "]";
	}

	public long getCourseId() {
		return courseId;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

}

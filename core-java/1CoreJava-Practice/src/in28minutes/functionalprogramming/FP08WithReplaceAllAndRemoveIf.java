package com.functionalprogrammingbyin28minutes;

import java.util.ArrayList;
import java.util.List;

public class FP08WithReplaceAllAndRemoveIf {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS");
		replaceWithUppercase(courses);
		removeIfLengthLessThen4(courses);

	}

	private static void removeIfLengthLessThen4(List<String> courses) {
		List<String> modifyableCourses = new ArrayList<String>(courses);
		modifyableCourses.removeIf(str -> str.length() < 4);
		System.out.println("Removed courses with length less than 4: " + modifyableCourses);

	}

	private static void replaceWithUppercase(List<String> courses) {
		// replaceAll()
		// courses.replaceAll(str -> str.toUpperCase());//ImmutableCollections

		List<String> modifyableCourses = new ArrayList<String>(courses);
		modifyableCourses.replaceAll(str -> str.toUpperCase());
		System.out.println("Modified courses: " + modifyableCourses);
	}

}

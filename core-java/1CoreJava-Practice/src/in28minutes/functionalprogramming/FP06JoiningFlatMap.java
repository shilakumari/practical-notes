package com.functionalprogrammingbyin28minutes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP06JoiningFlatMap {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "Docker");
		joiningWithCourses(courses);
		streamOfStringArrayToStreamOfStringByflatMap(courses);

		getTuplesWithSameLength(courses);

		// Intermediate operations are lazy
		System.out.println("Print course with length greater than 11 in upper-case: "
				+ courses.stream().peek(System.out::println).filter(course -> course.length() > 11)
						.map(String::toUpperCase).peek(System.out::println).findFirst());

	}

	private static void getTuplesWithSameLength(List<String> courses) {
		List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "Docker");
		System.out.println("Tuples:"
				+ courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
						.collect(Collectors.toList()));
		System.out.println("Tuples with different length:"
				+ courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
						.filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
		System.out.println("Tuples with same length:" + courses.stream()
				.flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length())
						.map(course2 -> List.of(course, course2)))
				.filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));

	}

	private static void streamOfStringArrayToStreamOfStringByflatMap(List<String> courses) {
		// map()- get Stream-of-String-array, By flatMap()- get Stream-of-String
		System.out.println("split(): " + courses.stream().map(course -> course.split("")).collect(Collectors.toList()));
		System.out.println("flatMap(): " + courses.stream().map(course -> course.split("")).flatMap(Arrays::stream)
				.collect(Collectors.toList()));
		System.out.println("flatMap() distinct value: " + courses.stream().map(course -> course.split(""))
				.flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
	}

	// joining()
	private static void joiningWithCourses(List<String> courses) {
		System.out.println("Joining space: " + courses.stream().collect(Collectors.joining(" ")));
		System.out.println("Joining ,: " + courses.stream().collect(Collectors.joining(",")));
	}

}

package com.functionalprogrammingbyin28minutes;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClassAndHighOrderFun {

	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		Predicate<Course> noOfStudentsGreaterThan20000Predicate = course -> course.getNoOfStudents() > 20000;
		Predicate<Course> noOfStudentsGreaterThan10000Predicate = course -> course.getNoOfStudents() > 10000;
		Predicate<Course> noOfStudentsLessThan10000Predicate = course -> course.getNoOfStudents() < 10000;

		// allMatch, noneMatch, anyMatch
		System.out.println(courses.stream().allMatch(noOfStudentsGreaterThan20000Predicate));
		System.out.println(courses.stream().noneMatch(noOfStudentsGreaterThan10000Predicate));
		System.out.println(courses.stream().anyMatch(noOfStudentsLessThan10000Predicate));

		// Comparator, comparingInt(), reversed()
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents)
				.reversed();
		Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore).reversed();

		System.out.println("Comparing by noOfStudents in increasing: "
				+ courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));
		System.out.println("Comparing by noOfStudents in decreasing: "
				+ courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));
		System.out.println("Comparing by noOfStudents and reviewScore: "
				+ courses.stream().sorted(comparingByNoOfStudentsAndReviewScore).collect(Collectors.toList()));

		System.out.println("Comparing by noOfStudents in increasing by skipping first 3 courses: "
				+ courses.stream().sorted(comparingByNoOfStudentsIncreasing).skip(3).collect(Collectors.toList()));

		System.out.println("Comparing by noOfStudents in increasing and getting one course: "
				+ courses.stream().sorted(comparingByNoOfStudentsIncreasing).limit(1).collect(Collectors.toList()));

		// takeWhile(), dropWhile()
		System.out.println("All Course: " + courses);
		System.out.println("Take While: "
				+ courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));
		System.out.println("Drop While"
				+ courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

		// max(Comparator), min(Comparator), findFirst(), orElse(), findAny()
		System.out.println(courses.stream().max(comparingByNoOfStudentsAndReviewScore));
		System.out.println(courses.stream().min(comparingByNoOfStudentsAndReviewScore));
		System.out.println(courses.stream().min(comparingByNoOfStudentsAndReviewScore)
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		System.out.println(courses.stream().filter(noOfStudentsGreaterThan10000Predicate).findFirst());// Optional.empty
		System.out.println(courses.stream().filter(noOfStudentsGreaterThan20000Predicate).findAny());

		// sum(), average(), count(), max(), min()
		System.out.println(
				courses.stream().filter(noOfStudentsGreaterThan20000Predicate).mapToInt(Course::getNoOfStudents).sum());

		System.out.println(courses.stream().filter(noOfStudentsGreaterThan20000Predicate)
				.mapToInt(Course::getReviewScore).average());

		System.out.println(courses.stream().filter(noOfStudentsGreaterThan20000Predicate)
				.mapToInt(Course::getReviewScore).count());

		System.out.println(
				courses.stream().filter(noOfStudentsGreaterThan20000Predicate).mapToInt(Course::getReviewScore).max());

		System.out.println(
				courses.stream().filter(noOfStudentsGreaterThan20000Predicate).mapToInt(Course::getReviewScore).min());

		// groupingBy() with counting()
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		System.out.println(courses.stream().collect(
				Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));

		// Higher Order Function => this function return function
		// int cutoffReviewScore = 90;
		Predicate<Course> reviewScoreGreaterThan90 = createPredicateWithCutoffReviewScore(90);
		Predicate<Course> reviewScoreGreaterThan95 = createPredicateWithCutoffReviewScore(95);
		System.out.println("Courses with review score greater than 90: "
				+ courses.stream().filter(reviewScoreGreaterThan90).collect(Collectors.toList()));

	}

	private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
		return course -> course.getReviewScore() > cutoffReviewScore;
	}

}

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}
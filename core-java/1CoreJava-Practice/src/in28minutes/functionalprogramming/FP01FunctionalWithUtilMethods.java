package com.functionalprogrammingbyin28minutes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FP01FunctionalWithUtilMethods {

	public static void main(String[] args) {
		printAllListElement(List.of(12, 9, 13, 4, 6));
		printEvenNumberInList(List.of(12, 9, 13, 4, 6));
		printSquaresOfEvenNumber(List.of(12, 9, 13, 4, 6));
		printOddNumberInList(List.of(12, 9, 13, 4, 6));
		getCubesOfOddNumber(List.of(12, 9, 13, 4, 6));
		System.out.println("Addition of list numbers: " + addListNumbers(List.of(12, 9, 13, 4, 6)));
		System.out.println("Smallest data: " + findMinValueInList(List.of(12, 9, 13, 4, 6)));
		System.out.println("Largest data: " + findMaxValueInList(List.of(12, 9, 13, 4, 6)));

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS");
		printAllCourses(courses);
		printCoursesContainSpring(courses);
		print4LettersCourses(courses);
		printLengthOfCourses(courses);

		List<String> fruits = List.of("Apple", "Banana", "Mango");
		introOfOptional(fruits);

		getUniqueData(List.of(12, 9, 13, 4, 4, 4, 4, 6));
		getSortedList(List.of(12, 9, 13, 4, 4, 4, 4, 6));

		sortedWithComparator(courses);

		System.out.println("Print list of Even numbers: " + getListOfEvenNumbers(List.of(12, 9, 13, 4, 6)));
		System.out.println("Print list of courses with their length: " + getListOfCourseAndLength(courses));
	}

	private static Map<String, Integer> getListOfCourseAndLength(List<String> courses) {
		return courses.stream().collect(Collectors.toMap(course -> course, course -> course.length()));
	}

	private static List<Integer> getListOfEvenNumbers(List<Integer> list) {
		return list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
	}

	private static void sortedWithComparator(List<String> courses) {
		System.out.println("Sorted courses based on Comparator: ");
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);// sorted based
																										// on str length
	}

	private static void getSortedList(List<Integer> list) {
		System.out.println("Sorted list: ");
		list.stream().sorted().forEach(System.out::println);
	}

	private static void getUniqueData(List<Integer> list) {
		System.out.println("Unique Data: ");
		list.stream().distinct().forEach(System.out::println);
	}

	private static int findMaxValueInList(List<Integer> list) {
		return list.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
	}

	private static int findMinValueInList(List<Integer> list) {
		return list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);
	}

	private static int addListNumbers(List<Integer> list) {
		// Stream of number into one result value-> "reduce()"
		// list.stream().reduce(0, (x, y) -> x + y);
		return list.stream().reduce(0, Integer::sum);
	}

	private static void introOfOptional(List<String> fruits) {
		Optional<String> optional = fruits.stream().filter(fruit -> fruit.startsWith("B")).findFirst();
		System.out.println(optional);// Optional[Banana]
		System.out.println(optional.isEmpty());// false
		System.out.println(optional.isPresent());// true
		System.out.println(optional.get());// Banana
		Optional<String> fruit = Optional.of("Apple");
		Optional<String> empty = optional.empty();// for empty value
	}

	private static void printLengthOfCourses(List<String> courses) {
		System.out.println("Print course length");
		courses.stream().map(course -> course + ": " + course.length()).forEach(System.out::println);
	}

	private static void getCubesOfOddNumber(List<Integer> list) {
		System.out.println("Print Cubes of odd number");
		list.stream().filter(n -> n % 2 != 0).map(num -> num * num * num).forEach(System.out::println);
	}

	private static void printSquaresOfEvenNumber(List<Integer> list) {
		System.out.println("Print Square");
		list.stream().filter(n -> n % 2 == 0).map(num -> num * num).forEach(System.out::println);
	}

	private static void print4LettersCourses(List<String> courses) {
		System.out.println("Print courses whose name has atleast 4 charecter: ");
		courses.stream().filter(str -> str.length() >= 4).forEach(System.out::println);
	}

	private static void printCoursesContainSpring(List<String> courses) {
		System.out.println("Print courses that containing the word -> Spring: ");
		courses.stream().filter(str -> str.contains("Spring")).forEach(System.out::println);
	}

	private static void printAllCourses(List<String> courses) {
		courses.stream().forEach(System.out::println);

	}

	private static void printOddNumberInList(List<Integer> list) {
		System.out.println("Print odd number: ");
		list.stream().filter(n -> n % 2 != 0).forEach(System.out::println);// n->n%2==0 is Lambda expression
	}

	private static void printEvenNumberInList(List<Integer> list) {
		System.out.println("Print even number: ");
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

	}

	private static void printAllListElement(List<Integer> list) {
		// list.stream().forEach(FP01Functional::print);
		list.stream().forEach(System.out::println); // System.out::println is Method reference
	}

	private static void print(int number) {
		System.err.println(number);
	}
}

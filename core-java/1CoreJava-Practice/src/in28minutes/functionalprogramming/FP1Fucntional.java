package in28minutes.functionalprogramming;

import java.util.List;

public class FP1Fucntional {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "Hibernate", "API", "Microservices", "AWS", "Docker",
				"PCF", "Azure", "Kubernate");
		// PrintCourcesListFuctional(courses);

		// printAllNumberInListFunctional(List.of(1, 2, 5, 4, 6, 3));
		printNumbersInListFunctional(List.of(1, 2, 5, 4, 6, 3, 5));
		// sumOfNumbersInListFunctional(List.of(1, 2, 5, 4, 6, 3));

	}

	private static void PrintCourcesListFuctional(List<String> courses) {
		// Print all courses
		// courses.stream().forEach(System.out::println);

		// Print courses those contain "String"
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);

		// Print courses where length>=4
		courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);

		// Print courses where length>=4
		courses.stream().map(course -> course + " " + course.length()).filter(course -> course.length() >= 4)
				.forEach(System.out::println);
	}

	private static void print(int number) {
		System.out.println(number);
	}

	private static void printAllNumberInListFunctional(List<Integer> numbers) {
		// Using Method Reference (::)
		// numbers.stream().forEach(FP1Fucntional::print);
		// Using static method println()
		numbers.stream().forEach(System.out::println);
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printNumbersInListFunctional(List<Integer> numbers) {
		// To printEven: Using filter() with Method Reference(::)
		numbers.stream().filter(FP1Fucntional::isEven).forEach(System.out::println);

		// To printEven: Using filter() with Lambda Expression
		numbers.stream().filter(number -> (number % 2 == 0)).forEach(System.out::println);

		// To get number's cube: Using map() mappingEvenNumber
		numbers.stream().filter(number -> (number) % 2 == 0)
				.map(number -> number + " Cube: " + (number * number * number)).forEach(System.out::println);

		// To get largestNumber: using conditional operator (?:)
		// int largestNumber = numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x >
		// y ? x : y);
		int largestNumber = numbers.stream().reduce(0, (x, y) -> x > y ? x : y);
		System.out.println("Largest Number: " + largestNumber);

		// To sum of number's square: using conditional operator (?:)
		int sumOfNumberSquare = numbers.stream().map(x -> x * x).reduce(0, FP1Fucntional::add);
		System.out.println("Sum of number's square: " + sumOfNumberSquare);

		// To remove duplicates: Using distinct()
		numbers.stream().distinct().forEach(System.out::println);

	}

	private static int add(int aggregate, int nextNumber) {
		return aggregate + nextNumber;
	}

	private static void sumOfNumbersInListFunctional(List<Integer> numbers) {
		// To sum: Using reduce() with Method Reference(::)
		int sumOfAllNumbers = numbers.stream().reduce(0, FP1Fucntional::add);
		System.out.println("sumOfAllNumbers: " + sumOfAllNumbers);

		// To sum: Using reduce() with Lambda Expression
		int sumOfAllNumbers1 = numbers.stream().reduce(0, (x, y) -> x + y);
		System.out.println("sumOfAllNumbers1: " + sumOfAllNumbers1);

		// To sum: Using reduce() with predefined sum() Of Integer class
		// int sumOfAllNumbers3 = numbers.stream().reduce(Integer.MIN_VALUE,
		// Integer::sum);
		int sumOfAllNumbers3 = numbers.stream().reduce(0, Integer::sum);
		System.out.println("sumOfAllNumbers3: " + sumOfAllNumbers3);
	}

}

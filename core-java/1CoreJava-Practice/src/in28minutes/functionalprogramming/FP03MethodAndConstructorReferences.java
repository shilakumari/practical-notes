package com.functionalprogrammingbyin28minutes;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodAndConstructorReferences {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS");
		// Method Reference - System.out::println
		courses.stream().forEach(System.out::println);

		Supplier<String> supplier = () -> new String();
		// Constructor Reference - String::new;
		Supplier<String> supplier2 = String::new;
		System.out.println("Constructor Reference: " + supplier2.get().getClass().getName());
	}

}

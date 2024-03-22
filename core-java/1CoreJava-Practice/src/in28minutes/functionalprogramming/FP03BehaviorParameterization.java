package com.functionalprogrammingbyin28minutes;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {
	public static void main(String[] args) {
		List<Integer> list = List.of(12, 9, 13, 4, 6);
		System.out.println("Print Even");
		filterAndPrint(list, n -> n % 2 == 0);

		System.out.println("Print Odd");
		filterAndPrint(list, n -> n % 2 != 0);

		// Function<? super Integer, ? extends Integer> mappingFunction = x -> x * x;
		System.out.println("Square of numbers: " + mapAndCreateNewList(list, x -> x * x));
		System.out.println("Cube of numbers: " + mapAndCreateNewList(list, x -> x * x * x));
		System.out.println("Double of numbers: " + mapAndCreateNewList(list, x -> x + x));

	}

	private static List<? extends Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> mapper) {
		return numbers.stream().map(mapper).collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> list, Predicate<? super Integer> predicate) {
		list.stream().filter(predicate).forEach(System.out::println);
	}
}

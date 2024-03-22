package com.functionalprogrammingbyin28minutes;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05StreamCreationWay {

	public static void main(String[] args) {
		List<Integer> list = List.of(12, 9, 13, 4, 6);
		int[] arr = { 12, 9, 13, 4, 6 };

		// 1. Stream by stream(): contains element of Integer wrapper classes
		System.out.println("list.stream(): " + list.stream());
		streamCreatingByOf();
		streamCreatingByArrays(arr);

		createSteamOf1to10();
		printSumOf10EvenNumbers();
		getListOf10EvenNumbersDouble();
		bigNumberCalculation();
	}

	// To handle big value BigInteger used
	private static void bigNumberCalculation() {
		System.out.println("Addition 1 to 50: "
				+ LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::add));// 1276

		// LongStream.rangeClosed(1,50).reduce(1, (x,y)->x*y);//Not handled big-value

		System.out.println("Multiplication 1 to 50: " + LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE, BigInteger::multiply));// 30414093201713378043612608166064768844377641568960512000000000000
	}

	private static void getListOf10EvenNumbersDouble() {
		// By boxed()- boxing primitive into wrapper class
		System.out.println("List of 10 even number square: "
				+ IntStream.iterate(2, n -> n * 2).limit(10).boxed().collect(Collectors.toList()));
	}

	private static void printSumOf10EvenNumbers() {
		System.out.println("Print sum of first 10 Even Numbers:"
				+ IntStream.iterate(2, n -> n + 2).limit(1).peek(System.out::println).sum());

	}

	private static void createSteamOf1to10() {
		System.out.println("IntStream 1 to 9 sum: " + IntStream.range(1, 10).sum());
		System.out.println("IntStream 1 to 10 sum: " + IntStream.rangeClosed(1, 10).sum());
		System.out.println("IntStream sum of 10 numbers: " + IntStream.iterate(1, n -> n + 2).limit(10).sum());
		System.out.println("Print alternative 10 numbers and their sum: "
				+ IntStream.iterate(1, n -> n + 2).limit(10).peek(System.out::println).sum());
	}

	// 3. Arrays.stream(): this stream contains primitive values
	private static void streamCreatingByArrays(int[] arr) {
		System.out.println("Arrays.stream(): " + Arrays.stream(arr));
		System.out.println(Arrays.stream(arr).average());
		System.out.println(Arrays.stream(arr).min());
		System.out.println(Arrays.stream(arr).max());
		System.out.println(Arrays.stream(arr).sum());
	}

	// 2. Stream by of(): contains element of Integer wrapper classes
	private static void streamCreatingByOf() {
		System.out.println("Stream.of(): " + Stream.of(12, 9, 13, 4, 6));
		System.out.println(Stream.of(12, 9, 13, 4, 6).count());
		System.out.println(Stream.of(12, 9, 13, 4, 6).reduce(0, Integer::sum));
	}

}

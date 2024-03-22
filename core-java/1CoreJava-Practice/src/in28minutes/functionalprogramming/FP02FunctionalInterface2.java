package com.functionalprogrammingbyin28minutes;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FP02FunctionalInterface2 {
	public static void main(String[] args) {

		// BiPredicate- Take 2 i/p and return boolean
		BiPredicate<Integer, String> biPredicate = (num, str) -> {
			return num < 10 && str.length() > 2;
		};
		System.out.println("BiPredicate: " + biPredicate.test(5, "Shaila"));

		// BiFunction- Take 2 i/p and return something
		BiFunction<Integer, String, String> biFunction = (num, str) -> {
			return num + " " + str;
		};
		System.out.println("BiFunction: " + biFunction.apply(5, "Shaila"));

		// BiConsumer- Take 2 i/p and return nothing
		BiConsumer<Integer, String> biConsumer = (a, b) -> {
			System.out.println("BiConsumer: ");
			System.out.println(a);
			System.out.println(b);
		};
		biConsumer.accept(5, "Shaila");

		// IntBinaryOperator
		// IntPredicate
		// IntFunction
		// IntConsumer
		// IntSupplier
		// IntToLongFunction
		// IntToDoubleFunction
		// IntUnaryOperator

		// Boolean, Long, Double, Float
	}
}

package com.functionalprogrammingbyin28minutes;

import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP02FunctionalInterface {

	public static void main(String[] args) {
		squaresOfEvenNumbers(List.of(12, 9, 13, 4, 6));
		System.out.println("Addition of list numbers: " + addListNumbers(List.of(12, 9, 13, 4, 6)));
		getRandomIntegerUnder1000();
		getTrippleValue();
	}

	// Supplier - No input -> return something
	private static void getRandomIntegerUnder1000() {
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		System.out.println("Print Random data under 1000: " + randomIntegerSupplier.get());
	}

	// Unary Operator- take one i/p and return same type o/p.
	private static void getTrippleValue() {
		UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
		System.out.println("Print Triple of given value: " + unaryOperator.apply(10));
	}

	// Binary Operator
	private static int addListNumbers(List<Integer> list) {
		// Stream of number into one result value-> "reduce()"
		// list.stream().reduce(0, (x, y) -> x + y);
		BinaryOperator<Integer> sumVar = Integer::sum;
		BinaryOperator<Integer> sumVar2 = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				return i + j;
			}
		};
		return list.stream().reduce(0, sumVar2);
	}

	// Predicate, Function, Consumer
	private static void squaresOfEvenNumbers(List<Integer> list) {
		System.out.println("Print Square");
		// list.stream().filter(n->n%2==0).map(num->num*num).forEach(System.out::println);
		Predicate<Integer> isEvenPredicate = n -> n % 2 == 0;
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer n) {
				return n % 2 == 0;
			}
		};

		// Here, take integer and return string
		// Function<Integer,String> squareFunction = num -> num*num+"";
		Function<Integer, Integer> squareFunction = num -> num * num;
		Function<? super Integer, ? extends Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer num) {
				return num * num;
			}
		};
		Consumer<Integer> sysoutConsumer = System.out::println;
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println(i);
			}
		};
		list.stream().filter(isEvenPredicate2).map(squareFunction2).forEach(sysoutConsumer2);
	}

}

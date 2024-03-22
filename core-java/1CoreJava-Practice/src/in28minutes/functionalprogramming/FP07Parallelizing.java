package com.functionalprogrammingbyin28minutes;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP07Parallelizing {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();

		//System.out.println("Sum without parallel(): " + LongStream.range(0,1000000000).sum());
		System.out.println("Sum with parallel(): " + LongStream.range(0, 1000000000).parallel().sum());
		System.out.println(System.currentTimeMillis() - time);
		
		System.out.println("Sum with parallel(): " + IntStream.range(0, 1000000000).parallel().reduce(0, Integer::sum));
		System.out.println(System.currentTimeMillis() - time);

	}

}

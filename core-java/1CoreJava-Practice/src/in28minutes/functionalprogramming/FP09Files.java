package com.functionalprogrammingbyin28minutes;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP09Files {

	public static void main(String[] args) throws Exception {
		getFileData();
	}

	private static void getFileData() throws Exception {
		System.out.println("File data printed line by line: ");
		Files.lines(Paths.get("myfile.txt")).forEach(System.out::println);

		System.out.println("Print all files and directory: ");
		Files.list(Paths.get(".")).forEach(System.out::println);

		System.out.println("Print only directory: ");
		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

		System.out.println("Printed file data: ");
		Files.lines(Paths.get("myfile.txt")).map(str -> str.split(" ")).flatMap(Arrays::stream)
				.forEach(System.out::println);
		System.out.println("Printed distinct file data: ");
		Files.lines(Paths.get("myfile.txt")).map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().sorted()
				.forEach(System.out::println);
	}

}

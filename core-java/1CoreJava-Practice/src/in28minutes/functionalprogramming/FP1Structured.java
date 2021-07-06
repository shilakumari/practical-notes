package in28minutes.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

public class FP1Structured {

	public static void main(String[] args) {
		// printAllNumberInListStructured(List.of(1, 2, 5, 4, 6, 3));
		// printEvenNumberInListStructured(List.of(1, 2, 5, 4, 6, 3));
		// prinElementSeperatedWithComma();
		prinElementSeperatedWithHyphen();

	}

	private static void prinElementSeperatedWithHyphen() {
		System.out.println("Seperate string with hyphen");
		String str = "7843rbvhjfc3e87894ytuvb";
		String seperatedWithHyphen = String.join("-", str.substring(0, 8), str.substring(8, 12), str.substring(12, 16),
				str.substring(16, str.length()));
		System.out.println(seperatedWithHyphen);
		seperatedWithHyphen = "";
		for (int i = 0; i < str.length(); i++) {
			seperatedWithHyphen = (i == 8 || i == 12 || i == 16) ? seperatedWithHyphen + "-" + str.charAt(i)
					: seperatedWithHyphen + str.charAt(i);
		}
		System.out.println(seperatedWithHyphen);
	}

	private static void prinElementSeperatedWithComma() {
		// Need to map in String, because joining() allowed String
		// List.of("1", "2", "5", "4", "6").stream().collect(Collectors.joining(","));
		// List.of('1', '2', '5', '4',
		// '6').stream().map(String::valueOf).collect(Collectors.joining(","));
		String commaSeperatedListElement = List.of(1, 2, 5, 4, 6).stream().map(String::valueOf)
				.collect(Collectors.joining(","));
		System.out.println(commaSeperatedListElement);
	}

	private static void printEvenNumberInListStructured(List<Integer> numbers) {
		// for (int number : numbers) {if (number % 2 == 0) {
		// System.out.println(number);}}
		List.of(1, 2, 5, 4, 6, 3).stream().filter(e -> e % 2 == 0).forEach(System.out::println);
	}

	private static void printAllNumberInListStructured(List<Integer> numbers) {
		// for (int number : numbers) { System.out.println(number); }
		numbers.stream().forEach(System.out::println);
	}

}

package in28minutes.java11.stringmethods;

public class StringNewApiRunner {

	public static void main(String[] args) {
		runNewUtilityMethods();
	}

	private static void runNewUtilityMethods() {
		System.out.println("".isBlank());// true
		System.out.println(" ".isBlank());// true
		// String str = null;
		// System.out.println(str.isBlank());// NullPointerException

		System.out.println(" S K ".strip());// S K
		System.out.println(" S K ".strip().replace(" ", "@"));// S@K
		System.out.println(" S K ".stripLeading().replace(" ", "@"));// S@K@
		System.out.println(" S K ".stripTrailing().replace(" ", "@"));// @S@K
		"Line1\nLine2\nLine3\nLine4".lines().forEach(System.out::println);

		System.out.println("UPPER".transform(s -> s.substring(2)));// PER
		System.out.println("My name is %s. My age is %d.".formatted("Shila Kumari", 23));
	}

}

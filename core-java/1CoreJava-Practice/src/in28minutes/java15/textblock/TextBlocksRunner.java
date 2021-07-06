package in28minutes.java15.textblock;

public class TextBlocksRunner {

	public static void main(String[] args) {
		String strings = doWithoutTextBlock();
		System.out.println("Without Text Block\n" + strings);

		String textBlockString = doWithTextBlock();
		System.out.println("With Text Block\n" + textBlockString);

	}

	private static String doWithTextBlock() {
		String textBlock1 = """
				Line1
					Line2
				"Line3"
				Line4
				""";

		String textBlock2 = """
				Line1: %s
				Line2: %d
				Line3
				Line4
				""".formatted("How many line in this Text Block", 4);
		return textBlock2;
	}

	private static String doWithoutTextBlock() {
		String str = "Line1\n\tLine2\n\"Line3\"\nLine4\n";
		return str;
	}

}

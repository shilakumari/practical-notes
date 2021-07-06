package in28minutes.java14.switchexpression;

public class SwitchExpressionRunner {

	public static void main(String[] args) {
		String dayName = doBeforeJDK14(3);
		System.out.println("Without using Switch Expression\n" + dayName);

		String nameOfTheDay = doWithSwitchExpresion(3);
		System.out.println("With using Switch Expression\n" + nameOfTheDay);
	}

	private static String doWithSwitchExpresion(int day) {
		String weekDay = switch (day) {
		// case 0 -> weekDay = "Sunday";
		case 0 -> {
			System.out.println("Do some complex logic here");
			yield "Sunday";
		}
		case 1 -> weekDay = "Monday";
		case 2 -> weekDay = "Tuesday";
		case 3 -> weekDay = "Wednesday";
		case 4 -> weekDay = "Thursday";
		case 5 -> weekDay = "Friday";
		case 6 -> weekDay = "Saturday";
		default -> throw new IllegalArgumentException("Invalid option: " + day);
		};
		return weekDay;
	}

	private static String doBeforeJDK14(int day) {
		String dayOfWeek = "";
		switch (day) {
		case 0:
			dayOfWeek = "Sunday";
			break;
		case 1:
			dayOfWeek = "Monday";
			break;
		case 2:
			dayOfWeek = "Tuesday";
			break;
		case 3:
			dayOfWeek = "Wednesday";
			break;
		case 4:
			dayOfWeek = "Thursday";
			break;
		case 5:
			dayOfWeek = "Friday";
			break;
		case 6:
			dayOfWeek = "Saturday";
			break;
		default:
			throw new IllegalArgumentException("Invalid option: " + day);
		}
		return dayOfWeek;
	}

}

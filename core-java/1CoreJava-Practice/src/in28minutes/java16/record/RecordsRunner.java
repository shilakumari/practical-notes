package in28minutes.java16.record;

public class RecordsRunner {

	/*
	 * record Person(String name, String email, String phoneNumber) { //Compact
	 * constructor, only allowed in records Person { if (name == null) { throw new
	 * IllegalArgumentException("name is null"); } }
	 * 
	 * Person(String name, String email, String phoneNumber) { if (name == null) {
	 * throw new IllegalArgumentException("name is null"); } this.name = name;
	 * this.email = email; this.phoneNumber = phoneNumber; } }
	 */

	public static void main(String[] args) {
		System.out.println("Record introduced in JDK 16");
		/*
		 * Person person = new Person("Ranga", "ranga@123in28minutes", "123-345-4569");
		 * Person person1 = new Person("Ranga", "ranga@123in28minutes", "123-345-4569");
		 * Person person2 = new Person("Ranga1", "ranga@123in28minutes",
		 * "123-345-4569"); System.out.println(person.equals(person1));// true
		 * System.out.println(person.equals(person2));// false
		 */
	}

}

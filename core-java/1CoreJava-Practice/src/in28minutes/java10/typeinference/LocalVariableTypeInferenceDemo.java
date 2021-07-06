package in28minutes.java10.typeinference;

import java.util.List;
import java.util.function.Predicate;

public class LocalVariableTypeInferenceDemo {

	public static void main(String[] args) {
		System.out.println("Local Variable Type Inference introduced in Java 10");
		doTypeInference();
	}

	private static void doTypeInference() {
		List<String> name1 = List.of("Ram", "Shyam");
		List<String> name2 = List.of("Sita", "Gita");
		// List<List<String> > names = List.of(name1, name2);
		// Instead of List<List<String> >, we use type inference var
		var names = List.of(name1, name2);

		// var v = null;//Not allowed for var
		// var v = "";
		// final var names = List.of(name1, name2);//we can use final

		for (var name : names) {
			System.out.println(name);
		}
		names.stream().forEach(System.out::println);

		// name1.stream().filter(name -> name.length() <
		// 5).forEach(System.out::println);

		var filterName = name1.stream().filter(name -> name.length() < 5);
		filterName.forEach(System.out::println);
	}

}

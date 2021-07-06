package in28minutes.java10.copyof;

import java.util.ArrayList;
import java.util.List;

public class UnmodifiableCollectionByCopyOf {

	public static void main(String[] args) {
		// getList();
		getUnmodifiableList();
	}

	private static void getUnmodifiableList() {
		// We can create unmodifiable list by of() and copyOf() methods
		// List<String> unmodifiableList1 = List.of("Ram", "Mohan", "Sita", "Gita");

		List<String> unmodifiableList = List.of("Ram", "Mohan", "Sita", "Gita");
		System.out.println(unmodifiableList);
		// Adding Ratan
		// unmodifiableList.add("Ratan");//Exception
		// System.out.println(unmodifiableList);
	}

	private static void getList() {
		List<String> modifiableList = new ArrayList<String>();
		modifiableList.add("Ram");
		modifiableList.add("Mohan");
		modifiableList.add("Sita");
		modifiableList.add("Gita");
		System.out.println(modifiableList);
		// Adding Ratan
		modifiableList.add("Ratan");
		System.out.println(modifiableList);
	}

}

package in28minutes.java9.modularization.util;

import java.util.List;

import in28minutes.java9.modularization.sorting.BubbleSort;

public class MySortingUtil {

	public List<String> sort(List<String> names){
		BubbleSort bubbleSort = new BubbleSort();//ctrl+1
		return bubbleSort.sort(names);
	}
}

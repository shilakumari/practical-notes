package in28minutes.java9.modularization.consumer;

import java.util.List;
import java.util.logging.Logger;

import in28minutes.java9.modularization.util.MySortingUtil;

public class MySortingUtilConsumer {
	private static Logger logger = Logger.getLogger(MySortingUtilConsumer.class.getName());

	public static void main(String[] args) {
		MySortingUtil sortingUtil = new MySortingUtil();
		List<String> sorted = sortingUtil.sort(List.of("Ranga", "Ravi", "Sathish", "Ashish"));
		logger.info(sorted.toString());
		
	}

}
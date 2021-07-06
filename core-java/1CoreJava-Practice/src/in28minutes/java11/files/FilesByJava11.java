package in28minutes.java11.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesByJava11 {

	public static void main(String[] args) throws IOException {
		readAndWriteInFile();

	}

	private static void readAndWriteInFile() throws IOException {
		//Read from file
		Path path = Paths.get("./filesample/sample.txt");
		String fileContent = Files.readString(path);
		System.out.println(fileContent);

		String content = fileContent.replace("fine", "good");
		
		//Write in file
		Path newFilePath = Paths.get("./filesample/sample-new.txt");
		Files.writeString(newFilePath, "Hi, i am  In28minutes.\n".concat(content));
	}

}

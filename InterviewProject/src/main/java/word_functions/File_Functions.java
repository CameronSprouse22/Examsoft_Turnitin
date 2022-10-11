package word_functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Functions {

	static public String ReadFile(String path) {
		StringBuilder sb = new StringBuilder();
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				sb.append(myReader.nextLine());
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}

package word_functions;

import java.util.ArrayList;
import java.util.Hashtable;

import org.json.JSONArray;

public class Word_Split_And_Store {

	Hashtable<String, Single_Word_Data> wordHashTable = new Hashtable<String, Single_Word_Data>();
	ArrayList<Single_Word_Data> objectList = new ArrayList<Single_Word_Data>();

	public Word_Split_And_Store(String inputString) {
		addString(inputString);
	}

	//String.split or String Builder is likely less efficient
	//Hash table string conversion makes it less of a good choice 
	public boolean addString(String inputString) {
		if (inputString.length() > 2147483647) {
			System.out.println("String too large for int");
			return false;
		}
		
		char[] inputArray = inputString.toCharArray();

		int startingCharForWord = 0;
		
		for (int placeInString = getFirstChar(inputArray); inputArray.length > placeInString; placeInString++) {
			if (inputArray[placeInString] == ' ' || inputArray.length == placeInString+1) {
				char[] foundWordArray = new char[startingCharForWord + 1];

				for(int x = 0;startingCharForWord >= 0; x++) {
					foundWordArray[x] = inputArray[placeInString - startingCharForWord];
					startingCharForWord--;
				}

				if(foundWordArray[0] != ' ') { 
					processWord(foundWordArray, placeInString - foundWordArray.length+1);
				}
				startingCharForWord = 0;
			} else {
				startingCharForWord++;
			}
		}
		return true;
	}
	
	private void processWord(char[] foundWordArray, int atPosition) {

		String key =new String(foundWordArray).trim();
		if(!key.equals("")) {
			if (wordHashTable.get(key) != null) {
				Single_Word_Data single_Word_Dataword = wordHashTable.get(key);
				single_Word_Dataword.occurrenceOfWord(atPosition);
			} else {
				Single_Word_Data single_Word_Data = new Single_Word_Data(foundWordArray, atPosition);
				wordHashTable.put(key, single_Word_Data);
				objectList.add(single_Word_Data);
			}
		}
	}

	public JSONArray getResultInJson() {
		JSONArray jsonArray=new JSONArray();
		
		for( Single_Word_Data currentWordObject : objectList) {
			jsonArray.put(currentWordObject.getJsonObject());
		}
		return jsonArray;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Single_Word_Data currentSingle_Word_Data : objectList) {
			sb.append(currentSingle_Word_Data.toString());
			System.out.println(currentSingle_Word_Data.toString());
		}
		return sb.toString();
	}



	private int getFirstChar(char[] inputArray) {
		for (int placeInString = 0; inputArray.length > placeInString; placeInString++) {
			if (inputArray[placeInString] != ' ') {
				return placeInString;
			}
		}
		return inputArray.length;

	}

}

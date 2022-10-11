package word_functions;

import org.json.JSONObject;

class Single_Word_Data {
	
 	char[] word;
	int occurrences;
	int lastFoundAt;
	int firstFoundAt;
	
	
	Single_Word_Data(char[] foundWordArray,int firstFoundAt){
		this.word=foundWordArray;
		this.occurrences=1;
		this.firstFoundAt=firstFoundAt;
		this.lastFoundAt=firstFoundAt;
	}
	
	void occurrenceOfWord(int lastFoundAt) {
		occurrences++;
		this.lastFoundAt=lastFoundAt;
	}
	
	public String toString() {
		return occurrences + "  "+new String(word);
		
	}

	public Object getJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("word", new String(word));
		jsonObject.put("occurrences", occurrences);
		jsonObject.put("lastFoundAt", lastFoundAt);
		jsonObject.put("firstFoundAt", firstFoundAt);
		
		return jsonObject;
	}

}

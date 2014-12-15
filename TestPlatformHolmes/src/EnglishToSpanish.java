import java.util.ArrayList;
import java.util.List;

public class EnglishToSpanish {
//Fields for List to String Array
	private List<String[]> dictionary;
	
	public EnglishToSpanish() {
		dictionary = new ArrayList<String []> (0);
		
		//Add words to the dictionary
		addEntry("this" , "esta");
		addEntry("dog" , "pero");
		addEntry("is", "es");
		addEntry("a" , "un");
		addEntry("father" , "padre");
	}
	
	//Adds new words to dicitonary list.
	public void addEntry(String e, String s) {
		String entry [] = {e,s};
		dictionary.add(entry);
	}
	
	//translate function
	public String translate(String s) {
		String result = ""; //Blank Word
		
		//Search for translation
		for (int w = 0; w < dictionary.size(); w++) {
			if (s.equals(dictionary.get(w) [0])) {
				result = dictionary.get(w) [0]; //Get Match
			}
		}
		
		if (result.equals("")) {
			result = s; // Set to incoming word
		}
		
		return result; //Gives back to the program
	}//End translate
}

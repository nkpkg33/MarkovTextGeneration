import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

public class SecondLevelTwitterTextModel {
	
	private HashMap<String, Bag> map;
	

	public SecondLevelTwitterTextModel() {
		map = new HashMap<String, Bag>();
	}

	private Bag getBagForWord(String word) {
		Bag b = null;
		if (map.containsKey(word)) {
			b = map.get(word);
		} else {
			b = new Bag();
			map.put(word, b);
		}

		return b;
	}

	// Adds the observed word pair word and followingWord to the Markov model
	// data
	public void addWordPair(String word, String followingWord) {

		Bag b = getBagForWord(word);

		b.add(followingWord);

	}

	public void loadData(String filename) {
		
		String text = getFileAsString(filename);
		
		ArrayList<String> tweets = new ArrayList<String>();
		
		for (int i = 0; i < text.length(); i++) {
			if (text.indexOf("text: ", i) != -1) {
				tweets.add(text.substring(i, text.indexOf(" \"created_at\"", i)));
			}
		}
		
		ArrayList<String> arr = new ArrayList<String>();
		
		String temp = "";
		
		int state = 0;
		
		
		for (int i = 0; i < text.length(); i++){
			
			
			
			if (text.substring(i, i + 1).equals(" ") && state == 1){
				
				arr.add(temp);
				
				temp = "";
				
				state = 0;
				
			}
			
			else if (text.substring(i, i + 1).equals(" ") && state == 0){
				
				temp += text.substring(i, i + 1);
				
				state = 1;
				
				
			}
			
			else{
				
				temp += text.substring(i, i + 1);
				
			}
			
		}
		
		for (int i = 0; i < arr.size() - 1; i++){
			
			addWordPair(arr.get(i), arr.get(i + 1));
			
		}
		
		
		}
	

	public String predictNextWord(String word) {

		Bag b = map.get(word);
		if(b == null){
		System.out.println(word);
		}
			return b.getRandomByFrequency();
		
		
	}

	public static String getFileAsString(String path) {
		StringBuilder b = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (line != null) {
				b.append(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Something wrong: " + e.getMessage());
		}

		return b.toString();
	}

}

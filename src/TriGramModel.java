import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TriGramModel {
	
	private HashMap<String, Bag> map;

	public TriGramModel() {
		map = new HashMap<String, Bag>();
	}

	private Bag getBagForWord(String trigram) {
		Bag b = null;
		if (map.containsKey(trigram)) {
			b = map.get(trigram);
		} else {
			b = new Bag();
			map.put(trigram, b);
		}

		return b;
	}

	// Adds the observed word pair word and followingWord to the Markov model
	// data
	public void addWordPair(String trigram, String followingTrigram) {

		Bag b = getBagForWord(trigram);

		b.add(followingTrigram);

	}

	public void loadData(String filename) {
		String text = getFileAsString(filename);
		
		ArrayList<String> arr = new ArrayList<String>();
		
		String temp = "";
		
		for (int i = 0; i < text.length(); i++){
			
			temp += text.substring(i, i + 1);
			
			if (temp.length() == 3){
				
				arr.add(temp);
				
				temp = "";
				
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

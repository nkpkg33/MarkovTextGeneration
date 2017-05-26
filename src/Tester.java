import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

public class Tester {

	private static final int MAX_WORD_LENGTH = 100;

	public static void main(String[] args) {
		SecondLevelTwitterTextModel model = new SecondLevelTwitterTextModel();	// create your model
		model.loadData("condensed_2016.txt");		// load the data
		
		

		/*String output = "";

		String word = "Happy Birthday";
		
		output += word;

		for (int i = 0; i < MAX_WORD_LENGTH; i++) {
			String nextWord = model.predictNextWord(word);
			
			output += " " + nextWord;
			
			if (i % 8 == 0) output += "\n";    // add some line breaks in the output
			
			word = nextWord;
		}*/

		//System.out.println(output);
		
		/*System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		FiveGramModel model2 = new FiveGramModel();	// create your model
		model2.loadData("shakespeare.txt");		// load the data

		String output2 = "";

		String word2 = "When ";			// Choose starting word
		output2 += word2;

		for (int i = 0; i < MAX_WORD_LENGTH; i++) {
			String nextWord = model.predictNextWord(word);
			
			output2 += " " + nextWord ;
			
			if (i % 8 == 0) output2 += "\n";    // add some line breaks in the output
			
			word2 = nextWord;
		}

		System.out.println(output2);*/
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
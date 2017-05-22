public class Tester {

	private static final int MAX_WORD_LENGTH = 100;

	public static void main(String[] args) {
		ThirdLevelTextModel model = new ThirdLevelTextModel();	// create your model
		
		model.loadData("countofmontecristo.txt");		// load the data

		String output = "";

		String word = "He was a";
		
		output += word;

		for (int i = 0; i < MAX_WORD_LENGTH; i++) {
			String nextWord = model.predictNextWord(word);
			
			output += " " + nextWord;
			
			if (i % 8 == 0) output += "\n";    // add some line breaks in the output
			
			word = nextWord;
		}

		System.out.println(output);
		
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
}
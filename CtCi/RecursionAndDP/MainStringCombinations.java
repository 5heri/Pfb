public class MainStringCombinations {
	
	public static void main(String[] args) {

		String[][] allWords = {{"quick","lazy"} , {"brown","black","grey"}, {"fox","dog"}};
		Combinations c = new Combinations();

		String[] combinations = c.combine(allWords);

		for (String s : combinations) {
			System.out.println(s);
		}
	}

}

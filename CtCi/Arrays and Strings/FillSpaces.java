public class FillSpaces {

	public static void main(String[] args) {

		char[] str = "Mr John Smith    ".toCharArray();  // Mr%20John%20Smith
		int trueLength = 13;

		fill(str, trueLength);

		System.out.println(str);
	}

	private static void fill(char[] str, int trueLength) {

		int endPointer = str.length - 1;

		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				str[endPointer] = str[i];
				endPointer--;
			} else {
				str[endPointer] = '0';
				str[endPointer - 1] = '2';
				str[endPointer - 2] = '%';
				endPointer -= 3;
			}
		}
	}
}

import java.lang.StringBuilder;

public class CountAndSay {

	public static String getSeq(int n) {
		String number = "1";
		for (int i = 0; i < n; i++) {
			number = nextSeq(number);
		}
		return number;
	}

	private static String nextSeq(String number) {
		StringBuilder sb = new StringBuilder();

		char repeat = number.charAt(0);
		number = number.substring(1) + " "; // extra space makes sure last count is added
		int count = 1;

		for (char actual : number.toCharArray()) {
			if (repeat != actual) {
				sb.append(count + "" + repeat);
				count = 1;
				repeat = actual;
			} else {
				count++;
			}
		}
		return sb.toString();
	}	

	public static void main(String[] args) {
		String zero = getSeq(0);
		String one = getSeq(1);
		String two = getSeq(2);
		String three = getSeq(3);
		String four = getSeq(4);
		String five = getSeq(5);

		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);


	}
}

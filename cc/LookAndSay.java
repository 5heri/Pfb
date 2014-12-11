import java.lang.StringBuilder;

public class LookAndSay {
	

	private static String nextSeq(int in) {
		String number = "1";

		for (int i = 0; i < in; i++) {
			number = nextSeq(number);
		}
		return number;
	}

	private static String nextSeq(String number) {
		StringBuilder sb = new StringBuilder();

		char repeat = number.charAt(0);
		number = number.substring(1) + " ";
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
		String zero = nextSeq(0);
		String one = nextSeq(1);
		String two = nextSeq(2);
		String three = nextSeq(3);
		String four = nextSeq(4);
		String five = nextSeq(5);

		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);


	}


}

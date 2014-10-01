import java.lang.StringBuffer;

public class Compress {
	
	public static void main(String[] args) {
		String t = "aabcccccaaadddd";
		System.out.println(compressCount(t));
	}

	private static String compressCount(String str) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char currChar = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (currChar == str.charAt(i)) {
				count++;
			} else {
				sb.append(currChar);
				sb.append(count);
				count = 1;
				currChar = str.charAt(i);
			}
		}
		sb.append(currChar);
		sb.append(count);		

		String sbStr = sb.toString();

		if (sbStr.length() < str.length()) {
			return sbStr;
		} else {
			return str;
		}
	}

}

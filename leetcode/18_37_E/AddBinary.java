public class AddBinary {

	public static String addBinary(String a, String b){
		String res = "";
		int pA = a.length() - 1;
		int pB = b.length() - 1;
		int carry = 0;
		while (pA >= 0 || pB >= 0) {
			int bitA = pA < 0 ? 0 : Character.getNumericValue(a.charAt(pA));
			int bitB = pB < 0 ? 0 : Character.getNumericValue(b.charAt(pB));

			int added = (bitA + bitB + carry);

			if (added == 2) {
				added = 0;
				carry = 1;
			} else if (added == 3) {
				added = 1;
				carry = 1;
			} else {
				carry = 0;
			}
			res = added + res;
			pA--;
			pB--;
		}

		if (carry > 0) {
			res = carry + res;
		}
		return res;
	}

	public static void main(String[] args) {
		String b3 = "11";
		String b1 = "1";

		System.out.println(addBinary(b3, b3));
		System.out.println(addBinary(b1, b3));
		System.out.println(addBinary("1", "0"));
	}
		
}

public class Q_4 {
	
	public static void main(String[] args) {
		System.out.println(addWithOutPlus(-5, 3));
		System.out.println(addWithOutPlus(2, 20));
	}

	private static int addWithOutPlus(int a, int b) {

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
}

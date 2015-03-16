public class ExcelSheetColumnTitle {
	
	public static String excelTitle(int x) {
		String s = "";
		while (x > 0) {
			int rem = ((x - 1) % 26);
			char c = (char) (65 + rem);
			s = c + s;
			x -= rem;
			x /= 26;
		}
		return s;	
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++)
			System.out.println(excelTitle(i));
	}
	
}

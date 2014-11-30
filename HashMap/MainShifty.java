import java.util.List;

public class MainShifty {
	
	public static void main(String[] args) {
		GroupShifty gs = new GroupShifty();
		String[] words = {"HELLO","DUCK", "IFMMP", "CTBJ", 
							"LOL", "FWEM", "NOPED", "CUPS"};
		List<List<String>> lists = gs.groupTogether(words);

		System.out.println(lists);
	}
}

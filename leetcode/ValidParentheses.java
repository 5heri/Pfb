import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s1 = "";			  // valid
		String s2 = "{{}{[]()}}"; // valid
		String s3 = "{{[[}]]}";   // not valid
		String s4 = "{{[[]]}}";   // valid
		String s5 = "()[]{}";     // valid
		String s6 = "()";   // valid
		String s7 = "(]";	// not valid
		String s8 = "([)]"; // not valid
		String s9 = "}{";   // not valid

		System.out.println(isValid(s1));
		System.out.println(isValid(s2));
		System.out.println(isValid(s3));
		System.out.println(isValid(s4));
		System.out.println(isValid(s5));
		System.out.println(isValid(s6));
		System.out.println(isValid(s7));
		System.out.println(isValid(s8));
		System.out.println(isValid(s9));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isOpen(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || !openCloseCheck(stack.peek(), c)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isOpen(char c) {
		return c == '(' || c == '[' || c == '{';
	}

	private static boolean openCloseCheck(char o, char c) {
		if (o == '(') return c == ')';
		if (o == '[') return c == ']';
		if (o == '{') return c == '}';
		return false;
	}
	
}


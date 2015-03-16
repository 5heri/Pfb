import java.util.Stack;
import java.lang.StringBuilder;

public class SimplifyPath {
	
	public static String simplifyPath(String path) {
		String[] dirs = path.split("/");

		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < dirs.length; i++) {
			if (dirs[i].equals("..")) {
				if (!stack.isEmpty()) stack.pop();
			} else if (!dirs[i].equals(".") && dirs[i].length() != 0) {
				stack.push(dirs[i]);
			}
		}

		if (stack.isEmpty()) {
			sb.append("/");
		} else {
			while (!stack.isEmpty()) {
				sb.insert(0, stack.pop());
				sb.insert(0, "/");
			}
		}
		return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    private static void print(String[] a) {
    	for (int i = 0; i < a.length; i++) {
    		System.out.print(a[i] + " ");
    	}
    	System.out.println();
    }

}


import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {

	public List<String> generateParentheses(int n) {
    	char[] str = new char[n * 2];
    	List<String> list = new ArrayList<String>();
    	addParen(list, n, n, str, 0);
    	return list;
    }	

    private void addParen(List<String> list, int leftRem, 
    			int rightRem, char[] str, int count) {
    	
    	if (leftRem < 0 || rightRem < leftRem) return;

    	if (leftRem == 0 && rightRem == 0) {
    		list.add(new String(str));
    	} else {
    		if (leftRem > 0) {
    			str[count] = '(';
    			addParen(list, leftRem - 1, rightRem, str, count + 1);
    		}

    		if (rightRem > 0) {
    			str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
    		}
    	}
    }
}

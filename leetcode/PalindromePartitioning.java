import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
	
	/*public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> output = new ArrayList<String>();

		partition(s, 0, output, result);

		return result;
	}

	private static void partition(String s, int start, List<String> output, List<List<String>> result) {
		if (start == s.length()) {
			result.add(output);
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				output.add(s.substring(start, i+1));
				partition(s, i+1, output, result);
				//output.remove(output.size()-1);
			} else {
				//output.remove(output.size()-1);
			}
		}
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	*/

	 public static List<List<String>> partition(String s) {
        /*
            def partition(self, s):
                ret=[]
                if len(s)==0:
                    return [[]]
                for i in range(1,len(s)+1):
                    if self.isp(s[:i]):
                        for r in self.partition(s[i:]):
                            ret+=[[s[:i]]+r]
                return ret
            def isp(self, s):
                if len(s)==0:
                    return True
                for i in range(len(s)/2):
                    if s[i]!=s[len(s)-1-i]:
                        return False
                return True
        */
        List<List<String>> ret = new ArrayList<List<String>>();
        if(s.length()==0) {
            ret.add(new ArrayList<String>());
            return ret;
        }
        for(int i=1; i<=s.length(); i++) {
            if(isP(s.substring(0,i))) {
                for(List<String> r : partition(s.substring(i))) {
                    r.add(0, s.substring(0,i));
                    ret.add(r);
                }
            }
        }
        return ret;
    }
    private static boolean isP(String s) {
        if(s.equals("")) return true;
        for(int i=0; i<s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}
}

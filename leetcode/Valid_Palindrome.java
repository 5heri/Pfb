public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (!isAlphaNumeric(s.charAt(start))) {
				start++;
			} else if (!isAlphaNumeric(s.charAt(end))) {
				end--;
			} else {
				if (isSame(s.charAt(start), s.charAt(end))) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		}
		return true;
    }
    
    // Assuming @params are alphaNumerics
    private boolean isSame(char c1, char c2) { 
        return Math.abs(c1 - c2) == 'a' - 'A' || c1 == c2;
    }
    
    private boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c >= '0' && c <= '9';
    }
}

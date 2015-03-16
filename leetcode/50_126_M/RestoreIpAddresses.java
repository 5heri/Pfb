import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	
	public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length()>12) return res;
        dfs(res,"",s,0);
        return res;
    }

    public static void dfs(List<String> res, String buff, String s, int count) {
  		if (count == 3 && isValid(s)) {
  			res.add(buff + s);
  			return;
  		}

  		for (int i = 1; i < 4 && i < s.length(); i++) {
  			String substr = s.substring(0, i);
  			if (isValid(substr)) {
  				dfs(res, buff + substr + ".", s.substring(i), count + 1);
  			}
  		}
    }

    public static boolean isValid(String s) {
        if(s.charAt(0)=='0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
    	System.out.println(restoreIpAddresses("25525511135"));
    }

}
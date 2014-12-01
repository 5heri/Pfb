import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

	 // check for exact match
    public int search(String txt, String pat) {
    	int patLength = pat.length();
    	int txtLength = txt.length();
    	long prime = longRandomPrime();
    	long removingValue = getRemovingValue(patLength, prime);
    	long patHash = hash(pat, patLength, prime);

        if (txtLength < patLength) return txtLength;

        long txtHash = hash(txt, patLength, prime); 

        // check for match at offset 0
        if ((patHash == txtHash) && check(txt, 0, pat))
            return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = patLength; i < txtLength; i++) {
            // Remove leading digit, add trailing digit, check for match. 
            txtHash = (txtHash + prime - removingValue * 
            			txt.charAt(i - patLength) % prime) % prime; 
            txtHash = (txtHash*256 + txt.charAt(i)) % prime; 

            // match
            int offset = i - patLength + 1;
            if ((patHash == txtHash) && check(txt, offset, pat))
                return offset;
        }
        // no match
        return txtLength;
    }

    private long getRemovingValue(int length, long prime) {
    	long r = 1;
    	for (int i = 1; i < length; i++) {
    		r = (256 * r) % prime;
    	}
    	return r;
    }

    // Compute hash for key[0..M-1]. 
    private long hash(String key, int length, long prime) { 
        long h = 0; 
        for (int j = 0; j < length; j++) 
            h = (256 * h + key.charAt(j)) % prime; 
        return h; 
    } 

    // Las Vegas version: does pat[] match txt[i..i-M+1] ?
    private boolean check(String txt, int i, String pat) {
        for (int j = 0; j < pat.length(); j++) 
            if (pat.charAt(j) != txt.charAt(i + j)) 
                return false; 
        return true;
    }

    // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

}

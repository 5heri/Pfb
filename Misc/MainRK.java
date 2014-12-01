public class MainRK {
	
	public static void main(String[] args) {
        String pat = "abracadabra";
        String txt = "abacadabrabracabracadabrabrabracad";
        runRK(txt, pat);

        pat = "aab";
        txt = "aaab";
        runRK(txt, pat);
    }

    private static void runRK(String txt, String pat) {
    	RabinKarp searcher = new RabinKarp();
        int offset = searcher.search(txt, pat);
        System.out.println(offset);

        // print results
        System.out.println("text:    " + txt);

        // from brute force search method 1
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++)
            System.out.print(" ");
        System.out.println(pat);
    }

}


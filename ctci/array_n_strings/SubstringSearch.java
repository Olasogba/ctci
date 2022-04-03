import java.util.Scanner;

// find a substring b within a string B
class SubstringSearch {
	static int M = 0;
	static int n = 0;
	static int bHash = 0;
	static int SHash = 0;
	static int d = 256;
	static int h = 1;
	static int q = 101;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(",");
		M = s[0].length();
		n = s[1].length();
		// brute(s[0], s[1]);
		O_n(s[0], s[1]);
	}


	public static void brute(String S, String b) {
		// loop 
		// inner loop over n, break if found
		for(Integer i=0; i<M; i++) {
			String match = "";
			Integer j = 0;
			while(j<n) {
				if(b.charAt(j) != S.charAt(i+j)) break;
				match+=S.charAt(i+j);

				if(match.equals(b)) {System.out.println(true);}
				j++;
			}
		}
	}


	public static void O_n(String S, String b) {
		// define the hash value
		// define the hashes for the initial text and the pattern
		// check for a match
		// roll the window
		for(Integer i = 0; i<n-1; i++) {
			h=(h*d) % q;
		}

		for(Integer i=0; i<n; i++) {
			bHash = (d*bHash + b.charAt(i)) % q;
			SHash = (d*SHash + S.charAt(i)) % q;
		}


		for(Integer i=0; i<=M-n; i++) {
			if(bHash==SHash) {
				for(Integer j=0; j<n; j++) {
					if(b.charAt(j) != S.charAt(i+j)) break;
				}
				System.out.println(true);
			}

			if(i<M-n) {
				SHash = (d * (SHash-S.charAt(i)*h)+S.charAt(i+n)) % q;
				if(SHash<0)SHash += q;
			}
		}
	}


	public static boolean solve2(String s, String b) {
        // make first window, 
        // compare
        // slide
        var current = "";

        for(var i=0; i<b.length(); i++) {
            current+=String.valueOf(s.charAt(i));
        }

        for(var i=b.length(); i<=s.length(); i++) {
            System.out.println(current);
            if(current.equals(b)) return true;
            if(i<s.length()) {
                current = current.substring(1);
                current = current.concat(String.valueOf(s.charAt(i)));
            }
        }

        return false;
    }
}
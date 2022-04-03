import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Example: Given a smaller string s and a bigger string b, 
 * design an algorithm to find all permutations of the shorter
 * string within the longer one. Print the location of each permutation
 * 
 * 1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
    2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4   
 */
public class StringPermutations {
    public static void main(String[] args) {
        solve("BACDGABCDA", "ABCD");
        System.out.println();
        solve("AAABABAA", "AABA");
    }


    public static void solve(String s, String b) {
        // start the first window
        // compare
        // slide
        var idxs = new ArrayList<Integer>();
        var current = "";

        for(var i=0; i<b.length(); i++) {
            current+=String.valueOf(s.charAt(i));
        }

        
        for(var i=b.length(); i<=s.length(); i++) {
            if(isPermutation(b, current)) {
                idxs.add(i-b.length());
            }
            
            if(i<s.length()) {
                current = current.substring(1);
                current = current.concat(String.valueOf(s.charAt(i)));
            }
        }

        for(var i:idxs) {
            System.out.println(i);
        }
    }


    public static boolean isPermutation(String s, String t) {
        var x = s.toCharArray();
        var y = t.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        return new String(x).equals(String.valueOf(y));
    }
}

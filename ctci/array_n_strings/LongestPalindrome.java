import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Input: s = "cbbd"
    Output: "bb"

    Input: s = "a"
    Output: "a" 
 */



public class LongestPalindrome {
    public static void main(String[] args) {
        solve("bananas");
        solve("babad");
        solve("arr");
        solve("array");
    }    

    public static String solve(String s) {
        // generate all the substrings
        // add the palidromic ones to a list
        // return the longest
        var list = new ArrayList<String>();
        for(var i=0; i<s.length(); i++) {
            var j=i+1;
            var current = String.valueOf(s.charAt(i));
            while(j<s.length()) {
                current += String.valueOf(s.charAt(j));
                if(isPalindrome(String.valueOf(current))) {
                    list.add(String.valueOf(current));
                }
                j++;
            }
        }
        var largest = Integer.MIN_VALUE;
        var val = "";
        for(var i: list) {
            if(i.length() > largest) {
                largest = i.length();
                val = i;
            }
        }

        System.out.println(val);

        return val;
    }


    public static boolean isPalindrome(String s) {
        if(s.length()==1) return false;
        var a = s.toCharArray();
        var rev = new StringBuilder();
        var i=a.length-1;
        while(i>=0) {
            rev.append(a[i]);
            i--;
        }

        return new String(a).equals(rev.toString());
    }
}

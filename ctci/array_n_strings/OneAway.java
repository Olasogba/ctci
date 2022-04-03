import java.util.HashMap;
/**
     * One Away: There are three types of edits that can be performed on strings: insert a character, 
    remove a character, or replace a character. Given two strings, write a function to check if they are 
    one edit (or zero edits) away. 
    EXAMPLE 
    pale, ple -> true 
    pales, pale -> true 
    pale, bale -> true 
    pale, bake -> false
 */


public class OneAway {
    public static void main(String[] args) {
        System.out.println(solve3("ple", "pale"));
		System.out.println(solve3("pales", "pale"));
		System.out.println(solve3("pale", "bale"));
        System.out.println(solve3("plale", "balle"));
		System.out.println(solve3("pale", "bake"));
    }


    public static boolean solve(String a, String b) {		
		return atMostOneDiff(a, b);

    }
	
	
	public static boolean atMostOneDiff(String s, String t) {
		var map = new HashMap<Character, Integer>();
		var map2 = new HashMap<Character, Integer>();
		
		for(var i:s.toCharArray()) {
			if(!map.containsKey(i))
				map.put(i, 1);
			else map.put(i, map.get(i)+1);
		}
		
		
		for(var i:t.toCharArray()) {
			if(!map2.containsKey(i))
				map2.put(i, 1);
			else map2.put(i, map2.get(i)+1);			
		}

		var count = 0;
		for(var i:map.keySet())
			if(!map2.containsKey(i)) count++;
		
		return count <= 1;
	}

    public static boolean solve2(String s, String t) {
        if(s.length()<t.length()) return forRemove(t, s);
        if(t.length() < s.length()) return forRemove(s, t);
        return forReplace(s, t);
    }


    // insert -> diff by one. e.g pale, ple
    // remove -> diff by one e.g pale, ple
    // replace -> chars are exactly inplace, except one
    public static boolean forReplace(String s, String t) {
        var diff = false;
        for(var i=0; i<s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(diff) return false;
                diff = true;
            }
        }
        return true;
    }


    public static boolean forRemove(String bigger, String smaller) {
        // iterate over both
        // expect one diff
        // move on on the diff string
        // if you find another diff, return false
        var i = 0;
        var j=0;
        while(i<bigger.length()&&j<smaller.length()) {
            if(bigger.charAt(i) != smaller.charAt(j)) {
                if(i!=j) return false;
                i++; // move forward, all else should be the same for true
            } else {
                i++;
                j++;
            }
        }

        return true;
    }



    public static boolean solve3(String s, String t) {
        if(Math.abs(s.length()-t.length())> 1) return false;
        var bigger = t.length() < s.length() ? t : s;
        var smaller = s.length() < t.length() ? s : t;

        var i = 0;
        var j = 0;

        var found = false;

        while(i<bigger.length() && j<smaller.length()) {
            if(bigger.charAt(i) != smaller.charAt(j)) {
                if(found) return false;
                found = true;
                if(bigger.length()==smaller.length()) {
                    j++;
                }
            } else {
                j++;
            }
            i++;
        }

        return true;
    }
}

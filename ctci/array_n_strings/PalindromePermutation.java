/**
 *  Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 *  A palindrome is a word or phrase that is the same forwards and backwards. A permutation 
    is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. 

    EXAMPLE 
    Input: Tact Coa 
    Output: True (permutations: "taco cat", "atco eta", etc.)
 */

import java.util.HashMap;
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(solve2("aaabbbaaa"));
        System.out.println(solve2("abababa"));
        System.out.println(solve2("Tact Coa"));
        System.out.println(solve2("Tact"));
    }
	
	
	public static boolean solve(String s) {
		var map = new HashMap<Character, Integer>();
		for(Character c : s.toLowerCase().toCharArray()) {            
            if(Character.isWhitespace(c)) {continue;}
			if(!map.containsKey(c)) {
                map.put(c, 1);
            }
			else map.put(c, map.get(c)+1);
        }
		var count = 0;

		for(Integer i : map.values())
			if(i%2!=0) count++;

		return count <= 1;
	}


    public static boolean solve2(String s) {
        var foundOne = false;
        var table = buildFrequencyTable(s);
        for(var c : table) {
        }
        for(var c : table) {
            if(c % 2 != 0) {
                if(foundOne) return false;
                foundOne = true;
            }
        }

        return true;
    }


    public static int getCharNumber(Character c) {
        var a = Character.getNumericValue('a');
        var z = Character.getNumericValue('z');
        var x = Character.getNumericValue(c);

        if(a <= x && x <= z) {
            return x - a;
        }

        return -1;
    }


    public static int[] buildFrequencyTable(String s) {
        var table = new int[Character.getNumericValue('z')-Character.getNumericValue('a') + 1];
        
        for(var i : s.toCharArray()) {
            var num = getCharNumber(i);
            if(num != -1) {
                table[num]++;
            }
        }

        return table;
    }
}
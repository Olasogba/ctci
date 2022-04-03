/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the 
other. 
 */
import java.util.HashMap;

public class CheckPermutation {
    public static void main(String[] args) {
        String s = "Firstf";
		String t = "Tsriff";
		
		System.out.println(solve(s,t));
    }
	
	
	public static boolean solve(String s, String t) {
		// store one in a map
		// store the other in a map
		// loop over them comparing the keys
		var map = new HashMap<Character, Integer>();
		var map2 = new HashMap<Character, Integer>();
		
		for(Character c : s.toLowerCase().toCharArray())
			if(!map.containsKey(c))
				map.put(c, 1);
			else map.put(c, map.get(c)+1);
		
		for(Character c : t.toLowerCase().toCharArray())
			if(!map2.containsKey(c))
				map2.put(c, 1);
			else map2.put(c, map2.get(c)+1);
		
		for(Character c : map.keySet())
			if(!map.containsKey(c) || (map.get(c) != map2.get(c))) return false;
		
		return true;
	}
}

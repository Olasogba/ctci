/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you 
cannot use additional data structures?
 */
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class IsUnique {
	public static void main(String[] args) {
		String s = "trings";
		System.out.println(solve(s));
	}
	
	
	public static boolean solve(String s) {
		Map<Character, Integer> map = new HashMap();
		for(char i : s.toLowerCase().toCharArray()) {
			if(!map.containsKey(i))
				map.put(i, 1);
			else map.put(i, map.get(i)+1);	
		}
		
		if(map.values().stream().anyMatch(c -> c>1)) return false;
		
        return true;
	}
	
}
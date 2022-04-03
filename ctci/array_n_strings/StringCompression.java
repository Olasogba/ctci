
/**
 * String Compression: Implement a method to perform basic string compression using the counts 
    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the 
    "compressed" string would not become smaller than the original string, your method should return 
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(solve("aabcccccaaa")); //a2blc5a3
    }


    public static String solve(String s) {
		// hold a current string and current count (hold the first char)
		// if the new is not the current (starting loop on 1)
		// append the last current and its count 
		// else incr count and continue
		var count = 1;
		var current = s.charAt(0);
		var j=1;
		var toReturn = "";
		while(j<s.length()) {
			if(s.charAt(j) != current) {
				toReturn = toReturn.concat(String.valueOf(current)) + count;
				current = s.charAt(j);
                count = 1;
			} else {
				count++;
			}		
			j++;
		}
		return toReturn.concat(String.valueOf(current)) + count;
    }


    public static String solve2(String s) {
        // check for end and when differs
        var val = "";
        var count = 0;
        for(var i=0; i<s.length(); i++) {
            var current = s.charAt(i);
            count++;
            if(i+1>=s.length() || s.charAt(i+1) != current) {
                val += String.valueOf(current) + count;
                count = 0;
            }
        }

        return val;
    }
}

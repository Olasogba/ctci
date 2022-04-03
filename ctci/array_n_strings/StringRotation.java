/**
 *  Assume you have a method isSubstringwhich checks if oneword is a substring 
    of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one 
    call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat"). 
 */

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(solve("erbottlewat", "waterbottle"));
    }


    public static boolean solve(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length()==0) return false;
        return isSubstring(s.concat(s), t);
    }


    public static boolean isSubstring(String s, String t) {
        for(var i=0; i<=s.length()-t.length(); i++) {
            var match = "";
            for(var j=0; j<t.length(); j++) {
                if(s.charAt(i+j) != t.charAt(j)) break;
                match += String.valueOf(s.charAt(i+j));
                if(match.equals(t)) return true;                
            }
        }
        return false;
    }
    
}

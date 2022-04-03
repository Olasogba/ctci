import java.util.stream.Collectors;
import java.util.*;

/**
 * A function 

solution(a, b, c)

takes in three parameters 

A = ["Ames", "Sandy", "Squidward", SpongeBob"]
B = ["123456789", "789123456", "343456787", "115678456"]
C = "5678"

The Arrays A and B contains the names and numbers of people with their corresponding indexes.
Write a function that follows the following rules.

A(N) <= 100
B(N) <= 100
B[i] must be a digit and B[i](N) <= 9
C must be a digit and C(N) <= 9

The function must return the name with the corresponding index of a number that has the digits in C,
If more than one item in the B array contains those numbers, the solution should return the number
with the highest value starting with the digits in parameter C e.g.

Solution (A, B, C) //would return SpongeBob
 */

public class NameIndex {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        String c = "5678";
        a.add("Ames");
        a.add("Sandy");
        a.add("Squidward");
        a.add("SpongeBob");

        
        b.add("123456789");
        b.add("789123456");
        b.add("343456787");
        b.add("115678456");
        
        // solve(a,b,c);

        var x = new NameIndex();
        x.solve(a, b, c);
    }


    public static void solve(List<String> a, List<String> b, String c) {
        var map = new HashMap<String, Pair>();

        for(var i=0; i<a.size(); i++) {
            var entry = new Pair(a.get(i), b.get(i));
            map.put(b.get(i), entry);
        }

        List<String> keys = map.keySet().stream().filter(u -> u.contains(c)).collect(Collectors.toList());
        var larget = Integer.MIN_VALUE;
        var val = "";

        for(var i:keys) {
            var substr = i.substring(i.indexOf(c.charAt(0)));
            if(substr.length()>larget) {
                larget = substr.length();
                val = map.get(i).name;
            }
        }

        System.out.println(val);
    }
}



class Pair {
    public String index;
    public String name;
    public Pair(String name, String index) {
        this.name = name;
        this.index = index;
    }
}
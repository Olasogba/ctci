import java.util.ArrayList;
import java.util.HashMap;

/**
 * Print all positive integer solutions to the equation a**3 + b**3 = c**3 + d**3 
 * where a, b, c and d are integers between 1 and 1000
 * 
 */


public class PrintInteger {
    public static void main(String[] args) {
        solve();
    }


    public static void solve() {
        opt3();
    }


    public static void brute() {
        for(var a=1; a<=100; a++) {
            for (int b = 1; b <= 100; b++) {
                for(int c=1; c<=100; c++) {
                    for(int d=1; d<=100; d++) {
                        if(Math.pow(a, 3)+Math.pow(b, 3)==Math.pow(c, 3)+Math.pow(d, 3)) {
                            System.out.print(a+", ");
                            System.out.print(b+", ");
                            System.out.print(c+", ");
                            System.out.print(d);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }


    public static void opt1() {
        for(var a=1; a<=1000; a++) {
            for (int b = 1; b <= 1000; b++) {
                for(int c=1; c<=1000; c++) {
                    var aPow = Math.pow(a, 3);
                    var bPow = Math.pow(b, 3);
                    var cPow = Math.pow(c,3);
                    var d = Math.pow(aPow+bPow - cPow, 1/3);     
                    if(aPow + bPow == cPow + d) {
                        System.out.print(a+", ");
                        System.out.print(b+", ");
                        System.out.print(c+", ");
                        System.out.print((int)d);
                        System.out.println();
                    }
                }
            }
        }
    }


    public static void opt2() {
        var map = new HashMap<Integer, ArrayList<int[]>>();
        for(var c=1; c<=1000; c++) {
            for (int d = 1; d <= 1000; d++) {
                var result = Math.pow(c, 3) + Math.pow(d, 3);
                var app = new int[] {c, d};
                if(map.get(result)!=null) {
                    map.get((int)result).add(new int[]{c,d});
                } else {
                    map.put((int)result, new ArrayList<>());
                    map.get((int)result).add(new int[]{c,d});
                }
            }
        }

        for(var a=1; a<=1000; a++) {
            for (int b = 1; b <= 1000; b++) {
                var result = Math.pow(a, 3) + Math.pow(b, 3);
                var list = map.get((int)result);
                if(list != null) {
                    System.out.print(a+", ");
                    System.out.print(b+", ");
                    for (int[] is : list) {
                        System.out.print(is[0]+", ");
                        System.out.print(is[1]);                        
                    }
                    System.out.println();
                }
            }
        }
    }



    public static void opt3() {
        var map = new HashMap<Integer, ArrayList<int[]>>();
        for(var c=1; c<=1000; c++) {
            for (int d = 1; d <= 1000; d++) {
                var result = Math.pow(c, 3) + Math.pow(d, 3);
                var app = new int[] {c, d};
                if(map.get(result)!=null) {
                    map.get((int)result).add(new int[]{c,d});
                } else {
                    map.put((int)result, new ArrayList<>());
                    map.get((int)result).add(new int[]{c,d});
                }
            }
        }

        for(var i : map.values()) {
            for(var j : i) {
                for(var k : i) {
                    System.out.print(j + ", " + k);
                }
            }
        }
    }
}
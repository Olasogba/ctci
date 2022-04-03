/**
 * Question: Given two sorted arrays, find the number of elements in common. The arrays are the same length 
 and each has all distinct elements. 
 */

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

class TwoArray {

    public static void bruteForce(Integer[] arr, Integer[] arr2) {
        Integer count = 0;

        for (int i : arr) {
            for (int j : arr2) {
                if(i==j) count++;
            }
        }

        System.out.println(count);
    }

    public static void O_N_Time(Integer[] arr, Integer[] arr2) {
        Map<Integer, Integer> d1 = new HashMap<>();
        Map<Integer, Integer> d2 = new HashMap<>();
        for (Integer integer : arr) {
            d1.putIfAbsent(integer, 1);
        }
        for(Integer val : arr2) d2.putIfAbsent(val, 1);
        Integer count = 0;

        for(Integer i:arr)
            if(d2.containsKey(i)) count++;
        
        System.out.println(count);
    }


    public static void O_N_Space(Integer[] arr, Integer[] arr2) {
        // two loops
        // record where stopped in second
        // continue from there for other values in one
        // because you shouldn't search for found values or values less than found values

        Integer cacheIdx = 0;
        Integer count = 0;
        for (int i = 0; i < arr.length; i++) {
            Integer j = cacheIdx;
            while (j<arr2.length) {
                cacheIdx = j;
                if(arr[i]<arr2[j]) { //can't find, no need continuing to search
                    break;
                }
                if(arr[i]==arr2[j]) {
                    count++;
                    break;
                }
                j++;
            }
        }
        System.out.println(count);
    } 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] arr = Stream.of(scan.nextLine().split(" ")).map(c -> strToInt(c)).toArray(Integer[]::new);
        Integer[] arr2 = Stream.of(scan.nextLine().split(" ")).map(c -> strToInt(c)).toArray(Integer[]::new);

        bruteForce(arr, arr2);
        O_N_Time(arr, arr2);
        O_N_Space(arr, arr2);
    }


    public static int strToInt(String val) {
        try {
            return Integer.valueOf(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

/**
 * 13 27 35 40 49 55 59
17 35 39 40 55 58 60
 */
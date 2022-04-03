/**
 * Given an array of distinct integer values, count the number of pairs of integers that 
have difference k. For example, given the array { 1, 7, 5, 9, 2, 12, 3} and the difference 
k = 2,there are four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9). 
 */

import java.util.HashMap;


public class KDiffArray {
    public static void main(String[] args) {
	  int[] x = { 1, 7, 5,6,8, 9, 2, 12, 3,4,10,11,13,14,15,16,17,18,19,20};
	  int k = 2;
	  System.out.print(solve(x, k));
    }
	
	
	public static int solve(int[] arr, int k) {
		// return brute(arr, k);
        return opt(arr, k);
	
	}
	
	
	public static int brute(int[] arr, int k) {
		var count = 0;
		for(int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if(Math.abs(arr[i]-arr[j]) == 2) {
					count++;
				}
			}
		}	
        return count;	
	}
	
	public static int opt(int[] arr, int k) {
        
		var map = new HashMap<Integer, Integer>();
		var count = 0;
        for(var i : arr) {
			var res = i+k;
			map.put(res, i);
        }
		for (var i : arr) {
			if(map.get(i) != null) count++;
		}
		System.out.println(map.values());
		return count;	
	}
}
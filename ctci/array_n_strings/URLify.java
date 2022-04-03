/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string 
has sufficient space at the end to hold the additional characters, and that you are given the "true" 
length of the string. (Note: If implementing in Java, please use a character array so that you can 
perform this operation in place.) 

EXAMPLE 
Input: "Mr John Smith     ", 13 
Output: "Mr%20John%20Smith" 
 */

import java.util.ArrayList;

public class URLify {
    public static void main(String[] args) {
		System.out.println(solve2("Mr John Smith    ", 13));
    }
	
	
	public static String solve(String s, Integer length) {
		// loop over the array, replacing the spaces.
		// if the prev is %20, replace with nothing
		var arr = s.toCharArray();
		var list = new ArrayList<String>();
        length = s.trim().length();
		for(var i=0; i<length; i++) {
            if(!String.valueOf(arr[i]).equals(" ")) list.add(String.valueOf(arr[i]));
			if(i>0&&String.valueOf(list.get(list.size()-1)).equals("%20") && String.valueOf(arr[i]).equals(" ")){}
            else if(String.valueOf(arr[i]).equals(" ")) list.add("%20");
		}	

		return String.join("", list);
	}


    public static String solve2(String s, Integer l) {
        // count spaces
        // get the final length
        // start from back and replace the chars
        var arr  = s.toCharArray();
        var spaces = 0;
        for(var j=0; j<l; j++)
            if(arr[j]==' ') spaces++;

        var index = l + (spaces*2); // one char already covered in the original string, only need the add for two others
        System.out.println(index + " " + l);
        for(var k=l-1; k>=0; k--) {
            if(arr[k]==' ') {
                arr[index-1]='0';
                arr[index-2]='2';
                arr[index-3]='%';
                index = index-3;
            } else {
                arr[index-1]=arr[k];
                index--;
            }
        }
        return String.valueOf(arr);
    }
}

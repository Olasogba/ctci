// import java.util.*;

// public class Ground {

//     /**
//      * 
//      * Longest alternating subsequence
//         Medium Accuracy: 65.27% Submissions: 7118 Points: 4

//         A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the following relations :
//         x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....
//         Your task is to find the longest such sequence.

//         Example 1:

//         Input: nums = [1,5,4]
//         Output: 3
//         Explanation: The entire sequenece is a 
//         alternating sequence.

//         Examplae 2:

//         Input: nums = [1,17,5,10,13,15,10,5,16,8]
//         Ooutput: 4
//         Explanation: There are several subsequences
//         that achieve this length.
//         One is [1,17,5,10].

        

//         Your Task:
//         You don't need to read or print anyhting. Your task is to complete the function AlternatingaMaxLength() which takes the sequence  nums as input parameter and returns the maximum length of alternating sequence.

//         Expected Time Complexity: O(n)
//         Expected Space Complexity: O(1)
//      */
//     // solve the problem in O(n^2)
//     public static void main(String[] args) {
//         // run the condition check 4 as long as possible and update count
//         // if condition fails
//         // repeat the process from the next item
//         //--
//         // find the longest subs
//         var arr = new int[] {1,17,5,10,13,15,10,5,16,8};
//         System.out.println(solve(arr));
//         var arr2 = new int[] {1,5,4};
//         count=0;
//         temp=0;
//         currentSign="";
//         System.out.println(solve(arr2));
//     }

//     static int count = 0;
//     static int temp = 0;
//     static String currentSign = "";


//     public static int solve(int[] arr) {
//         for (int i = 0; i < arr.length-1; i++) {
//             if(currentSign=="") {
//                 currentSign = getSign(arr[i], arr[i+1]);
//                 temp+=2;
//             } else {
//                 if(currentSign == getSign(arr[i], arr[i+1])) { // condition fails
//                     temp++;
//                     count = temp < count ? count : temp;
//                     temp = 0;
//                 } else {
//                     temp++;
//                 }
//             }
//         }
//         count = temp < count ? count : temp;
//         return count;
       
//     }


//     public static String getSign(int a, int b) {
//         return a > b ? ">" : "<"; 
//     }


//     public static String getSignExpected(String sign) {
//         return sign == ">" ? "<" : ">";
//     }


//     // < > < > < > < > < < > < > < >
//     // 1 2 1 2 1 2 1 2 1 0 2 1 2 1 2
// }
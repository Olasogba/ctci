/**
 * '''
You're now a baseball game point recorder.

Given a list of strings, each string can be one of the following types:
1. 'Integer' (one round's score): Directly represents the number of points
   you get in this round
2. '+' (one round's score): Represents that the points you get in this round
   are the sum of the last two 'valid' round's points
3. 'D' (one round's score): Represents that the points you get in this round
   are the doubled data of the last valid round's points.
4. 'C' (an operation, which isn't a round's score): Represents the last 
   'valid' round's points you get were invalid and should be removed.

Each round's operation is permanent and could have an impact on the round
before and the round after.

You need to return the sum of the points you could get in all the rounds.


record(['5','2','C','D','+']) # 30
record(['5','-2','4','C','D','9','+','+']) # 27
'''

 */

public class BaseBallGame {
   // use an array to record the valid rounds - init to true
   public static void main(String[] args) {
      // var arr = new char[] {'5','2','C','D','+'};
      // var arr = new String[] {"5","2","4","C","D","9","+","+"}; // 55
      var arr = new String[] {"5","-2","4","C","D","9","+","+"}; // 27
      var s = new BaseBallGame();
      System.out.print(s.solve(arr));
   }


   public int solve(String[] array) {
      var check = new boolean[array.length];
      for(var i=0; i<array.length; i++) {
         if(array[i]=="C") {
            check[i] = false;
            var j=i-1;
            var cancel = 0;
            while(j>=0 && cancel < 1) {
               if(check[j]) {
                  check[j] = false;
                  cancel++;
               }
               j--;
            }
         } else {
            check[i] = true;
         }
      }

      var s = new Stack<Integer>();

      for(var i=0; i<array.length; i++) {
         if(check[i]) {
            if(array[i]=="D") {
               var a = s.pop().value;
               s.push(a);
               s.push(a*2);
            } else if(array[i]=="+") {
               var a = s.pop().value;
               var b = s.pop().value;
               s.push(b);
               s.push(a);
               s.push(a+b);
            }
             else {
               s.push(new Integer(String.valueOf(array[i])));
            }
         }
      }

      s.print();

      var sum =0;
      while(!s.isEmpty()) {
         sum+=s.pop().value;
      }
      return sum;
   }   
}

/**
 * '''
Given a string containing just the characters '(), ')', '{', '}', '[', and ']', 
determine if the input string is valid. The brackets must close in the correct 
order, "()" and "()[]{}" are all valid but "(])" and "([)]" are not. 

print(valid_parenthesis('()')) # true
print(valid_parenthesis('()[]{}')) # true
print(valid_parenthesis('(]')) # false
print(valid_parenthesis('([)]')) # false
print(valid_parenthesis('((()))')) # true
console.log(solve('({][({[}]})]})'))
console.log(solve('(){}[]{[]}{[]{()}}')) 
'''
 */

public class ValidParenthesis {
    public static void main(String[] args) {
        var s = new ValidParenthesis();
        System.out.println(s.solve("()"));
        System.out.println(s.solve("()[]{}"));
        System.out.println(s.solve("(]"));
        System.out.println(s.solve("([)]"));
        System.out.println(s.solve("((()))"));
    }

    public boolean solve(String str) {
        var stack = new Stack<Character>();
        var s = str.toCharArray();
        if(s.length % 2 != 0) return false;

        for(var i:s) {
            if(i=='{' || i=='[' || i=='(') {
                stack.push(i);
            } else {
                if(i=='}') {
                    var top = stack.peek();
                    if(top!=null && top.value=='{') stack.pop();
                } else if(i==']') {
                    var top = stack.peek();
                    if(top!=null && top.value=='[') stack.pop();
                } else {
                    var top = stack.peek();
                    if(top!=null && top.value=='(') stack.pop();
                }
            }
        }

        return stack.isEmpty();

        
    }
}

/**
 *  Write a program to sort a stack such that the smallest items are on the top. You can use
    an additional temporary stack, but you may not copy the elements into any other data structure
    (such as an array). The stack supports the following operations: push, pop, peek, and is Empty. 
 */

public class SortStack {
    public static void main(String[] args) {
        var q = new Stack<Integer>();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(55);
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);

        var s = new SortStack();

        var ans = s.sort(q);

        ans.print();
        
    }

    public void bubble_sort(Stack<Integer> stack) { // only doable because top is public
        var c1 = stack.top;
        var c2 = c1.next;

        while(c1.next != null) {
            c2 = c1.next;
            while(c2!=null) {
                if(c1.value>c2.value) {
                    swapNodes(c1, c2);
                }
                c2 = c2.next;
            }
            c1 = c1.next;
        }
    }


    private void swapNodes(StackNode<Integer> node, StackNode<Integer> node2) {
        var temp = node.value;
        node.value = node2.value;
        node2.value = temp;
    }

    private Stack<Integer> buffer = new Stack<>();

    public Stack<Integer> sort(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            var pop = stack.pop();
            while(!buffer.isEmpty() && buffer.peek().value < pop.value) {
                // copy over to s
                stack.push(buffer.pop().value);
            }

            // return to buffer
            buffer.push(pop.value);
        }

        return buffer;
    }
}

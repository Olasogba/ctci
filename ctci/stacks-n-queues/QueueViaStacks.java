/**: Implement a MyQueue class which implements a queue using two stacks.  */

public class QueueViaStacks {
    public Stack<Integer> stack1 = new Stack<>(); // store
    public Stack<Integer> stack2 = new Stack<>();

    public void add(Integer value) {
        // push to stack1
        stack1.push(value);
    }


    public void remove() {
        while(!stack1.isEmpty()) {
            var x = stack1.pop();
            stack2.push(x.value);
        }
        stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop().value);
        }
    }


    public Integer peek() {
        
        while(!stack1.isEmpty()) {
            var x = stack1.pop();
            stack2.push(x.value);
        }
        var x = stack2.peek();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop().value);
        }

        return x.value;
    }


    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


    public void print() {
        this.stack1.print();
    }


    public static void main(String[] args) {
        var q = new QueueViaStacks();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        q.print();

        q.remove();

        q.print();

        q.remove();

        q.add(10);

        q.print();


        /** OPTIMIZATION
         * Add: push to stack 2
         * Remove: if(stack1 is empty) copy over from stack2 and pop
         * Peek: same for remove, copy over from stack2 and peek
         * 
         * 
         */
    }
}

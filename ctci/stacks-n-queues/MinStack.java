/**
 * : How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */

public class MinStack {
    // push each node along with the current min at the time
    // this way when you pop, you always get the prev min
    public MinStackNode head;
    public Integer min = Integer.MAX_VALUE;

    public void push(Integer value) {
        var node = new MinStackNode(Math.min(value, min), value);
        if(this.head==null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.min = this.head.min;
    }


    public Integer pop() {
        if(this.head==null) return null;
        var val = this.head;
        this.head = val.next;
        this.min = this.head.min;
        return val.value;
    }


    public Integer min() {
        if(this.head==null) return null;
        return this.head.min;
    }

    public void print() {
        this.head.print();
    }

    public void printMin() {
        System.out.println(this.min());
    }


    public static void main(String[] args) {
        var s = new MinStack2();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(0);
        s.push(0);
        s.push(-1);
        s.push(-2);

        s.print();

        s.printMin();

        s.pop();
        s.print();
        s.printMin();

        s.pop();
        s.print();
        s.printMin();

        s.pop();
        s.print();
        s.printMin();

        s.pop();
        s.print();
        s.printMin();

    }

}

class MinStack2 extends Stack<Integer>  {
    Stack<Integer> inner = new Stack<Integer>();
    @Override
    public StackNode<Integer> push(Integer val) {
        var x = super.push(val);
        if(val <= this.min()) {
            inner.push(val);
        }
        return x;
    }

    @Override
    public StackNode<Integer> pop() {        
        var x = super.pop();
        if(x.value==inner.top.value) inner.pop();

        return x;
    }

    public void printMin() {
        System.out.println(this.min());
    }

    public Integer min() {
        if(inner.isEmpty()) return Integer.MAX_VALUE;
        return inner.top.value;
    }
}


class MinStackNode {
    public Integer min;
    public MinStackNode next;
    public Integer value;


    public MinStackNode(Integer min, Integer value) {
        this.min = min;
        this.value = value;
    }


    @Override
    public String toString() {
        var str = "[";
        var current = this;
        while(current.next != null) {
            str = str.concat(current.value + ", " );
            current = current.next;
        }

        return str.concat(current.value + "]");
    }

    public void print() {
        System.out.println(this.toString());
    }
}
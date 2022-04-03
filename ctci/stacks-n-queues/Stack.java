/** Implement a stack */
public class Stack<T> {
    // push
    // pop
    // peek
    // isEmpty
    public static void main(String[] args) {
        var s = new StackNode<>(1);
        s.next = new StackNode<>(2);
        s.next.next = new StackNode<>(3);
        s.next.next.next = new StackNode<>(4);
        s.next.next.next.next = new StackNode<>(5);

        // s.print();
        
        var t = new Stack<Integer>();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);
        t.push(5);

        t.print();

        t.pop();

        t.print();
    }

    public StackNode<T> top;

    public StackNode<T> push(T val) {
        var node = new StackNode<>(val);
        if(this.top == null) {
            this.top = node;
            return node;
        }
        node.next = this.top;
        this.top = node;

        return node;
    }


    public StackNode<T> pop() {
        if(this.top==null) return null;
        var item = this.top;
        this.top = this.top.next;
        return item;
    }


    public StackNode<T> peek() {
        return this.top;
    }


    public boolean isEmpty() {
        return this.top == null;
    }

    public void print() {
        if(this.top!=null) this.top.print();
    }
}

class StackNode<T> {
    public StackNode<T> next;
    public T value;

    public StackNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        var str = "[";
        var current = this;
        while(current.next!=null) {
            str += current.value + ", ";
            current = current.next;
        }

        return str.concat(current.value + "]");
    }

    public void print() {
        System.out.println(this.toString());
    }
}
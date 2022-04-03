/** Implement a queue */
public class Queue<T> {
    // add 
    // remove
    // peek
    // isEmpty
    public static void main(String[] args) {
        // var q = new Queue<Integer>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);

        // q.print();

        // q.remove();

        // q.print();
    }

    public QueueNode<T> top;
    public QueueNode<T> bottom;

    public QueueNode<T> add(T value) {
        var node = new QueueNode<>(value);
        if(this.bottom == null) {
            this.top = node;
            this.bottom = node;
        } else {
            this.bottom.next = node;
            this.bottom = node;
        }
        return node;
    }



    public QueueNode<T> remove() {
        if(this.bottom == null) return null;
        QueueNode<T> node = null;
        if(this.bottom==this.top) {
            node = this.top;
            this.top = null;
            this.bottom = null;
        } else {
            node = this.top;
            this.top = this.top.next;
        }

        return node;
    }


    public T peek() {
        if(this.top==null) return null;
        return this.top.value;
    }


    public boolean isEmpty() {
        return this.top == null;
    }

    public void print() {
        if(!this.isEmpty()) this.top.print();
    }
}


class QueueNode<T> {
    public QueueNode<T> next;
    public T value;

    public QueueNode(T value) {
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
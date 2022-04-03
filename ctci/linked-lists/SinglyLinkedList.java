
public class SinglyLinkedList<T> {
    class Node<T> {
        public T value;
        public Node<T> next;
        public Node(T _value) {
            value = _value;
            this.next = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public Node<T> head;
    public Node<T> tail;
    public Integer size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void print() {
        // System.out.println(this.head + ", tail: " + this.get(0) + " size: " + size);
        if(size!=0) {
            String str = "[";
            var count = 0;
            Node<T> current = this.head;
            while (count < size-1) {
                str = str.concat(current.value.toString()) + ", ";
                count++;
                current = current.next;
            }    
            str = str.concat(tail.value.toString()) + "]";
            System.out.println(str);
        }
        else System.out.println("[]");
    }


    public Node<T> get(Integer index) {
        if(index < 0 || index >= size) return null;
        var count = 0;
        var current = head;
        while(count < index) {
            current = current.next;
            count++;
        }

        return current;
    }


    public Node<T> unshift(T value) {
        var node = new Node(value);
        if(this.size==0) {
            this.head = node;
            this.tail = node;
        } else {
            var current = this.head;
            this.head = node;
            node.next = current;
        }
        this.size++;

        return node;
    }


    public Node<T> push(T value) {
        // return this.set(value, this.size);
        var node = new Node(value);
        if(this.size==0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }   
        size++;
        return node;
    }

    
    public Node<T> set(T value, Integer index) {
        if(index==0) return this.unshift(value);
        if(index==this.size) return this.push(value);
        if(index < 0 || index > size) throw new IllegalArgumentException("Index out of bounds");
        var node = new Node(value);
        if(this.size==0) {
            this.head = node;
            this.tail = node;
        } else {
            var current = this.get(index-1);
            var next = current.next;
            current.next = node;
            node.next = next;
        }
        this.size++;
        return node;
    }


    public Node<T> pop() {
        if(this.size == 0) return null;
        Node<T> toReturn = null;
        if(this.size==1) {
            toReturn = this.head;
            this.head = null;
            this.tail = null;
        } else {
            var newTail = this.get(size-2);
            toReturn = this.tail;
            newTail.next = null;
            this.tail = newTail;
        }
        this.size--;
        return toReturn;
    }


    public Node<T> shift() {
        Node<T> old = null;
        if(this.size==0) {
            this.tail = null;
            this.head = null;
        } else {
            var oldHead = this.head;
            this.head = oldHead.next;
            old = oldHead;
        }

        this.size--;
        return old;
    }


    public Node<T> removeAt(Integer index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
        if(index==0) return this.shift();
        if(index==size-1) return this.pop();

        var current = this.get(index-1);
        var toRemove = current.next;
        current.next = toRemove.next;
        this.size--;

        return toRemove;
    }


    public void reverse() {
        // swap and reverse
        var current = this.head;
        this.head = this.tail;
        this.tail = current;
        Node<T> prev = null;

        while(current!=null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        
        list.set(0, 0);
        list.set(1, 1);
        list.set(2, 2);
        list.push(3);
        list.push(6);
        list.print();
        list.removeAt(0);
        
        list.print();
        // list.reverse();
        // list.print();
    }
}

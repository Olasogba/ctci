// get
// insert
// push
// pop
// removeAt
// unshift
// shift
// reverse
// print

public class DoublyLinkedList<T> {
    class Node<T> {
        public final T value;
        public Node<T> next = null;
        public Node<T> prev = null;
        
        Node(T _value) {
            value = _value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public Node<T> head;
    public Node<T> tail;
    public Integer size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void print() {
		var str = new StringBuilder();
		str.append("[");
		var current = this.head;

		while(current.next!=null) {
			str.append(current.value + ", ");
			current = current.next;
		}

		if(current != null) {
			str.append(current.value+"]");
		} else {
			str.append("]");
		}
        System.out.println(str.toString());
    }

    public Node<T> get(Integer index) {
        if(this.size==0) return null;
        if(index<0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
        var count = 0;
        var current = this.head;
        while(count<index) {
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
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
        this.size++;

        return node;
    }

    public Node<T> shift() {
        if(this.size==0) return null;
        Node<T> toReturn = null;
        if(this.size==1) {
            toReturn = this.head;
            this.head = null;
            this.tail = null;
        } else {
            toReturn = this.head;
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;
        return toReturn;
    }

    public Node<T> insert(T value, Integer index) {
        var toInsert = new Node(value);
        if(index<0 || index > size) throw new IllegalArgumentException("Index out of bounds");
        if(index==0) return this.unshift(value);
        if(index==size) return this.push(value);

        var node = this.get(index-1);
        var next = node.next;
        node.next = toInsert;
        toInsert.prev = node;
        toInsert.next = next;
        next.prev = toInsert;

        this.size++;
        return toInsert;
    }

    public Node<T> push(T value) {
        var node = new Node(value);
        if(size==0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

        this.size++;
        return node;
    }

    public Node<T> pop() {
        if(this.size==0) return null;
        Node<T> toReturn = null;
        if(this.size==1) {
            toReturn = this.head;
            this.head = null;
            this.tail = null;
        } else {
            var oldTail = this.tail;
            this.tail = tail.prev;
            this.tail.next = null;
            toReturn = oldTail;
        }
        this.size--;
        return toReturn;
    }

    public Node<T> removeAt(Integer index) {
        if(index<0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
        if(this.size==0) return null;
        if(index==0) return this.shift();
        if(index==this.size-1) return this.pop();
        var prev = this.get(index-1);
        var toReturn = prev.next;
        prev.next = toReturn.next;
        toReturn.next.prev = prev;
        
        this.size--;
        return toReturn;
    }

    public void reverse() {
        // store new head and swap
		var current = this.head;
		var newHead = this.head;

		while(current!=null) {
			var prev = current.prev;
			current.prev = current.next;
			current.next = prev;
			newHead = current;
			current = current.prev;
		}

        this.head = newHead;
    }
    
    public static void main(String[] args) {
        var list = new DoublyLinkedList<Integer>();
        list.push(3);
        list.push(4);
        list.insert(0, 0);
        list.insert(1, 1);
        list.insert(2, 2);
        list.print();
        list.reverse();
        list.print();
    }
}

/** Palindrome: Implement a function to check if a linked list is a palindrome.  */

public class Palindrome {
    public static void main(String[] args) {
        var l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(2);
        l1.next.next.next = new Node(1);

        System.out.println(solve(l1));
    }


    public static boolean solve(Node l1) {
        // reverse and compare
        var clone = clone(l1);
        var reversed = reverse(l1);

        System.out.println(clone);
        System.out.println(reversed);

        while(clone!=null && reversed!=null) {
            if(clone.value != reversed.value) return false;
            clone = clone.next;
            reversed = reversed.next;
        }

        return clone==null && reversed == null;
    }


    public static Node clone(Node l) {        
        var current = l;
        var n = new Node(0);
        n.value = current.value;
        var cloned = n;
        while(current.next!=null) {
            n.next = new Node(current.next.value);
            n = n.next;
            current = current.next;
        }

        return cloned;
    }


    public static Node reverse(Node l) {
        var head = l;
        var tail  = l;
        while(tail.next!=null) {
            tail = tail.next;
        }

        var current = head;
        head = tail;
        tail = current;
        Node prev = null;

        while(current != null) {
            var n = current.next;
            current.next = prev;
            prev = current;
            current = n;
        }

        return prev;
    }
}


class Node {
    public Node next;
    public Integer value;

    public Node(Integer val) {
        this.value = val;
    }


    @Override
    public String toString() {
        var str = "[";
        var current = this;
        while(current.next!=null) {
            str += current.value + ", ";
            current = current.next;
        }

        return str.concat(current.value.toString())+"]";
    }
}

import java.util.HashMap;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
    beginning of the loop.
    DEFINITION
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
    as to make a loop in the linked list.
    EXAMPLE
    Input: A -> B -> C -> D -> E -> C [the same C as earlier]
    Output: C 
 */

public class LoopDetection {
    public static void main(String[] args) {
        var l = new Node(1);
        l.next = new Node(2);
        l.next.next = new Node(5);
        l.next.next.next = new Node(4);
        // l.next.next.next.next = l;

        System.out.println(solve(l));
    }


    public static boolean solve(Node n) {
        var map = new HashMap<Node, Boolean>();
        var current = n;

        while(current!=null) {
            if(map.containsKey(current)) return true;
            map.put(current, true);
            current = current.next;
        }

        return false;
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
        var count = 0;
        while(current.next!=null && count < 20) {
            str += current.value + ", ";
            current = current.next;
            count++;
        }

        return str.concat(current.value.toString())+"]";
    }
}
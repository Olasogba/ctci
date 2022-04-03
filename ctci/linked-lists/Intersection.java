import java.util.HashMap;

/**
 *  Intersection: Given two (singly) linked lists, determine if the two lists intersect. 
 *  Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth
    node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting. 
 */

public class Intersection {
    public static void main(String[] args) {
        Node l = new Node(1);
        l.next = new Node(2);
        l.next.next = new Node(3);
        l.next.next.next = new Node(4);


        var l2 = new Node(6);
        l2.next = new Node(7);
        l2.next.next = l.next.next;


        System.out.println(solve2(l, l2));
    }



    public static boolean solve1(Node l1, Node l2) {
        // if the nodes have the same tail then they're intersecting
        var t1 = l1;
        var t2 = l2;

        while(t1.next!=null) t1 = t1.next;
        while(t2.next!=null) t2 = t2.next;


        return t1==t2;
    }



    public static boolean solve2(Node l1, Node l2) {
        // use a hash map and check for a containing key
        var map1 = new HashMap<Node, Integer>();

        var t1 = l1;
        while(t1!=null) {
            map1.put(t1, 1);
            t1 = t1.next;
        }

        var t2 = l2;
        while(t2!=null) {
            if(map1.containsKey(t2)) return true;
            t2 = t2.next;
        }

        return false;
    }
}


class Node {
    public Integer value;
    public Node next;

    public Node(Integer val) {
        this.value = val;
    }
}

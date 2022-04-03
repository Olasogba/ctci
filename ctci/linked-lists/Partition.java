/**
     Write code to partition a linked list around a value x, such that all nodes less than x come
        before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
        to be after the elements less than x (see below). The partition element x can appear anywhere in the
        "right partition"; it does not need to appear between the left and right partitions.

        EXAMPLE
        Input : 1->4->3->2->5->2->3, 
        x = 3
        Output: 1->2->2->3->3->4->5

        Input : 1->4->2->10 
                x = 3
        Output: 1->2->4->10

        Input : 10->4->20->10->3 
                x = 3
        Output: 3->10->4->20->10 
*/



public class Partition {
    // have two lists
    // for lower values, add to lower list
    // for higher values, add to higher list
    // join both lists, if there is a before list
    public static void main(String[] args) {
        var node = new Node(1);
        node.next = new Node(4);
        node.next.next = new Node(8);
        node.next.next.next = new Node(9);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next.next = new Node(2);

        System.out.println();
        
        var x = solve(node, 8);
        
        while(x!=null) {
            System.out.println("X: "+x.value);
            x = x.next;
        }
    }

    public static Node solve(Node node, int x) {
        // before list
        Node beforeStart = null;
        Node beforeEnd = null;
        
        // after list
        Node afterStart = null;
        Node afterEnd = null;

        while(node!=null) {
            var next = node.next;
            
            // for independent copying
            node.next = null;
            if(node.value < x) {
                if(beforeStart==null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if(afterStart==null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if(beforeStart==null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }
}


class Node
{
    public Integer value;
    public Node next;

    public Node(Integer val) {
        value = val;
        next = null;
    }
}

public class DeleteNode {
    /**
     * : Implement an algorithm to delete a node in the middle (i.e., any node but
        the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
        that node.
        EXAMPLE
        lnput:the node c from the linked lista->b->c->d->e->f
        Result: nothing is returned, but the new linked list looks like a->b->d->e->f
     */
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        
        list.push(3);
        list.push(7);
        list.push(6);
        list.push(2);
        list.push(11);
        list.push(12);
        list.push(13);
        list.push(7);
        list.push(10);
        list.print();
        solve(list.head.next.next.next);
        list.size--;
        list.print();
    }


    public static boolean solve(SinglyLinkedList<Integer>.Node<Integer> node) {
        // simply copy data from the next node to the current node
        // then delete the next node
        if(node==null || node.next==null) return false;
        var current = node;
        var next = node.next;
        current.value = next.value;

        current.next = next.next;

        return true;
    }
}

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */

public class KthToLast {
    public static Integer stackCount = 0;
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        
        list.push(3);
        list.push(7);
        list.push(6);
        list.push(2);
        list.push(11);
        list.push(12);
        list.push(11);
        list.push(7);
        list.push(10);
        
        list.print();
        var kth = solve3(list.head, 3);
        System.out.println(kth);
        list.print();
    }


    public static SinglyLinkedList<Integer>.Node<Integer> solve(SinglyLinkedList<Integer>.Node<Integer> head, Integer k) {
        // get the size of the list
		// index = size-k
		// find
		var size = 0;
		var current = head;
		while(current!=null) {
			size++;
			current = current.next;
		}
		
        if(k==0) k=1;
		var idx = size-k;
		
		var count =0;
		current = head;
		while(count < idx) {
			count++;
			current = current.next;
		}
		
		return current;        
    } 

    

    public static SinglyLinkedList<Integer>.Node<Integer> solve2(SinglyLinkedList<Integer>.Node<Integer> head, Integer k) {
        // base case for no more node
        if(head==null) return null;

        // go to the last and reverse with recursion
        var node = solve2(head.next, k);
        
        // we've now gotten to the last, now start counting backwards through the stack
        stackCount++;
        if(stackCount==k) return head; // when we reach our target

        // lastly return the elements from the call stack
        return node;
    }


    public static SinglyLinkedList<Integer>.Node<Integer> solve3(SinglyLinkedList<Integer>.Node<Integer> head, Integer k) { 
        var n1 = head;
        var n2 = head;

        var i=0;
        while(i<k) {
            i++;
            n1 = n1.next;
        }

        while(n1!=null){
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }
}

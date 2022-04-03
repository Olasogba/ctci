/**
 *  You have two numbers represented by a linked list, where each node contains a single
    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    function that adds the two numbers and returns the sum as a linked list.
    EXAMPLE
    Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
    Output: 2 -> 1 -> 9. That is, 912.
	
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.
    EXAMPLE
    lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
    Output: 9 -> 1 -> 2. That is, 912. 
 */

public class SumLists {
    public static void main(String[] args) {
        var l1 = new Node(7);
        l1.next = new Node(1);
        l1.next.next = new Node(6);
        var l2 = new Node(5);
        l2.next = new Node(9);
        l2.next.next = new Node(2);

        var res = solve(l1, l2, 0);
        System.out.println(res);


        // follow up
        l1 = new Node(6);
        l1.next = new Node(1);
        l1.next.next = new Node(7);
        l2 = new Node(2);
        l2.next = new Node(8);
        // l2.next.next = new Node(5);
        System.out.println(followUp(l1, l2));
    }


    public static Node followUp(Node l1, Node l2) {
        // first pad the lists
        // sum the lists
        // prepend any carry value to the start of the list
        var n1 = listLength(l1);
        var n2 = listLength(l2);

        if(n1<n2) {
            l1 = padList(n2-n1, l1);
        } else {
            l2 = padList(n1-n2, l2);
        }

        var sum = sumListsHelper(l1, l2);

        if(sum.carry!=0) {
            return prependToList(sum.sum, sum.carry);
        }

        return sum.sum;
    }


    public static int listLength(Node l) {
        var count = 0;
        var n = l;

        while(n!=null) {
            count++;
            n = n.next;
        }

        return count;
    }


    public static Node padList(int padding, Node start) {
        var head = start;
        for(var i=0; i<padding; i++) {
            head = prependToList(head, 0);
        }

        return head;
    }


    public static Node prependToList(Node start, int value) {
        var node = new Node(value);
        if(start!=null) node.next = start;
        return node;
    }


    public static PartialSum sumListsHelper(Node l1, Node l2) {
        if(l1==null&&l2==null) return new PartialSum();

        var totSum = sumListsHelper(l1.next, l2.next);

        int adds = totSum.carry + l1.value + l2.value;

        totSum.sum = prependToList(totSum.sum, adds % 10);
        totSum.carry = adds/10;

        return totSum;
    }


    public static Node solve(Node l1, Node l2, int carry) {
		if(l1==null && l2==null&&carry==0) return null;
        var result = new Node(0);
		
		var total = carry;
		if(l1!=null) {
			total+=l1.value;
		}
		if(l2!=null) {
			total+=l2.value;
		}
		
		result.value = total % 10;
		
		if(l1!=null||l2!=null) {
			var more = solve(l1.next==null?null:l1.next, l2.next==null?null:l2.next, total >= 10 ? 1 : 0);
		
			result.next = more;
		}
		
		return result;
    }
}

class PartialSum {
    public Node sum = null;
    public int carry = 0;
}

class Node {
	public Integer value;
	public Node next;
	
	public Node(Integer val) {
		this.value = val;
		this.next = null;
	}


    @Override
    public String toString() {
        var str = "[";
        var x = this;
        while(x.next!=null) {
            str = str.concat(String.valueOf(x.value)).concat(", ");
            x = x.next;
        }

        str = str.concat(x.value + "]");

        return str;
    }
}

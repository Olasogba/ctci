import java.util.HashMap;
import java.util.HashSet;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list. 
 
    FOLLOW UP 
    How would you solve this problem if a temporary buffer is not allowed? 
 */

public class RemoveDuplicate {
	public static void main(String[] args) {
		// 1. 
		// 2. use two loops
		var l = new Node(1);
		l.next = new Node(2);
		l.next.next = new Node(2);
		l.next.next.next = new Node(3);
		l.next.next.next.next = new Node(4);
		l.next.next.next.next.next = new Node(3);
		l.next.next.next.next.next.next = new Node(4);
		l.next.next.next.next.next.next.next = new Node(4);
		l.print();

		solve2(l);

		l.print();

	}

	public static void solve2(Node l) {
		var current = l;
		var inner = current.next;
		var prev = current;
		while(current!=null) {
			inner = current.next;
			while(inner!=null) {
				if(inner.value==current.value) {
					prev.next = current.next;
					current = prev;
				}
				inner = inner.next;
			}
			prev = current;
			current = current.next;
		}
	}


	public static void solve(Node l) {
		var set = new HashSet<Integer>();
		var current = l;
		var prev = current;
		while(current!=null) {
			if(set.contains(current.value)) {
				prev.next = current.next;
				current = prev;
			} 
			set.add(current.value);
			prev = current;
			current = current.next;
		}
	}
}




class Node {
	public Integer value;
	public Node next;

	public Node(Integer value) {
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

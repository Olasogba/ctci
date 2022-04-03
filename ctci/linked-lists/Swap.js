/**
 * You are given the head of a linked list, and an integer k.

    Return the head of the linked list after swapping the values of
    the kth node from the beginning and the kth node from the end (the list is 1-indexed).  
 */

// define class
// save head
// get both refs
// swap
// return head


class Node {
    value;
    next;
    constructor(val) {
        this.value = val;
        this.next = null;
    }

    print() {
        var str ="["
        var current = this;
        while(current.next) {
            str += current.value + ", "
            current = current.next;
        }

        console.log(str + current.value + "]")
    }
}

function solve(node, k) {
    var head = node;
    
    // get kth from start
    var current = head
    var count = 1;
    while(count<k)  {
        count++;
        current = current.next;
    }
    var kthFromStart = current;


    // get kth from last
    var c1 = head;
    var c2 = head;
    var n1 = 0;
    var n2 = 0;

    while(n1<k) {
        c1 = c1.next;
        n1++;
    }

    while(c1!=null && c2 != null) {
        c1 = c1.next;
        c2 = c2.next;
    }

    var kthToEnd = c2;

    var temp = kthFromStart.value;
    kthFromStart.value = kthToEnd.value;
    kthToEnd.value = temp;

    return head;
}


// print, check
var list = new Node(1)
list.next = new Node(2)
list.next.next = new Node(3)
list.next.next.next = new Node(4)
list.next.next.next.next = new Node(5)

var list = new Node(7)
list.next = new Node(9)
list.next.next = new Node(6)
list.next.next.next = new Node(3)
list.next.next.next.next = new Node(2)
list.next.next.next.next.next = new Node(14)
list.next.next.next.next.next.next = new Node(2)
list.next.next.next.next.next.next.next = new Node(10)
list.next.next.next.next.next.next.next.next = new Node(09)

list.print()
var head = solve(list, 2);
list.print();
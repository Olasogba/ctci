import java.util.ArrayList;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
    threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
    composed of several stacks and should create a new stack once the previous one exceeds capacity.
    SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
    (that is, pop () should return the same values as it would if there were just a single stack).
    FOLLOW UP
    Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack. 
 */

public class SetOfStacks {
    public ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity = 0;
	
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	
	public void push(int value) throws Exception{
		var node = new Node(value);
		var stack = getLastStack();
		if(stack!=null && !stack.isFull()) {
			stack.push(node.value);
		} else {
			stack = new Stack(capacity);
			stack.push(node.value);
			stacks.add(stack);
		}
	}
	
	
	public Node pop() throws Exception {
		if(this.isEmpty()) throw new Exception("Set of stacks is empty!");
		var stack = getLastStack();
		var n = stack.pop();
		if(stack.isEmpty()) stacks.remove(stacks.size()-1);
        
        return n;
	}
	
	
	public Node popAt(int index) throws Exception {
		return leftShift(index, true);
	}
	
	public Node leftShift(int index, boolean removeTop) throws Exception {
		var stack = stacks.get(index);
		Node removedItem;
		if(removeTop) removedItem = stack.pop();
		else removedItem = stack.removeBottom();
        
		if(stack.isEmpty()) {
			stacks.remove(stack);
		} else if(index + 1 < stacks.size()) {
			// roll
			// remove bottom from the next and add it to the current;
			var v = leftShift(index+1, false);
			stack.push(v.value);
		}
		
		return removedItem;
	}
    
    public static void main(String[] args) throws Exception {
        
        var s = new SetOfStacks(3);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(3);
        s.push(3);
        s.push(-1);
        s.push(-1);
        s.print();
        s.popAt(0);
        s.print();
    }
	
	
	public Stack getLastStack() {
		if(stacks.size()==0) return null;
		var s = stacks.get(stacks.size()-1);

        return s;
	}
	
	
	public boolean isEmpty() {
		var last = this.getLastStack();
		return last==null || last.isEmpty();
	}

    public void print() {
        System.out.println("[");
        for(var i : stacks) i.print();
        System.out.println("]");
    }
	
	private class Stack {
		public Node top;
		public int capacity;
		public int size = 0;
	
		public Stack(int capacity) {
			this.capacity = capacity;
		}
		
		
		public void push(int value) throws Exception {
			if(this.isFull()) throw new Exception("Stack is full");
			var node = new Node(value);
			if(this.isEmpty()) {
				this.top = node;
			} else {
				node.next = this.top;
				this.top = node;
			}
			
			this.size++;
		}
	
	
		public void print() {
			if(this.top==null) {
				System.out.println("   []");
				return;
			}
			this.top.print();
		}
		
		
		public Node pop() {
			if(this.isEmpty()) return null;
			var node = this.top;
			this.top = this.top.next;
			size--;
			return node;
		}
		
		
		public boolean isEmpty() {
			return this.top == null;
		}
		
		
		public boolean isFull() {
			return this.size==this.capacity;
		}
		
		
		public Node removeBottom() {
			var current = this.top;
			while(current.next.next!=null) {
				current = current.next;
			}
			
			var x = current.next;
			current.next = null;
			size--;
			return x;
		}
	}
	
	
	private class Node {
		public int value;
		public Node next;
		
		public Node(int val) {
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
	
			if(current==null) return str.concat("]");
			return str.concat(current.value + "]");
		}
	
		public void print() {
			System.out.println("   " + this.toString());
	
		}
	}
}
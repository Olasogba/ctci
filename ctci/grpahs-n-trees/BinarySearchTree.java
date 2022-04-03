import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    //insert, bfs, dfs (pre, in, post orders)
    private Node<T> root;
    
    public void insert(T value) {
        var node = new Node<T>(value);
        if(this.root==null) {
            this.root = node;
        } else {
            var current = this.root;
            this.insertRecursive(current, node);
        }
    }

    private void insertRecursive(Node<T> parent, Node<T> child) {
        if(parent.compareTo(child.value) < 0) {
            if(parent.right==null) {
                parent.right = child;
            } else {
                insertRecursive(parent.right, child);
            }
        } else {
            if(parent.left==null) {
                parent.left = child;
            } else {
                insertRecursive(parent.left, child);
            }
        }
    }


    public void bfs() {
        var store = new ArrayList<T>();
        var queue = new Queue<Node<T>>();

        var current = this.root;

        this.bfs(current, store, queue);
    }

    private void bfs(Node<T> node, ArrayList<T> store, Queue<Node<T>> queue) {
        queue.add(node);
        while(!queue.isEmpty()) {
            var pop = queue.remove();
            store.add(pop.value.value);
            if(pop.value.left !=null) {
                queue.add(pop.value.left);
            }
            if(pop.value.right != null) {
                queue.add(pop.value.right);
            }
        }

        for(var i: store) {
            System.out.println(i);
        }
        
    }


    public void dfsPreOrder() {
        var s = this.dfsPreOrder(this.root, new ArrayList<T>());
        for(var r : s) {
            System.out.println(r);
        }
        // var c = this.root;
        // var s = new StringBuilder();
        // this.traversePreOrder(s, "", "", c);
        // System.out.println(s.toString());
    }


    private ArrayList<T> dfsPreOrder(Node<T> root, ArrayList<T> store) {
        var current = root;
        if(current.left != null) {
            dfsPreOrder(current.left, store);
        }
        store.add(current.value);
        if(current.right != null) {
            dfsPreOrder(current.right, store);
        }

        return store;
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node<T> node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value);
            sb.append("\n");
    
            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");
    
            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.right != null) ? "├──" : "└──";
    
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
        }
    }


    public void dfsInOrder() {

    }


    public void dfsPostOrder() {

    }


    public static void main(String[] args) {
        var s = new BinarySearchTree();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        s.insert(-2);
        s.insert(0);
        s.insert(6);
        s.insert(34);
        s.insert(12);s.insert(41);
        s.insert(84);
        s.insert(-5);
        
        

        s.dfsPreOrder();
    }
}


class Node<T extends Comparable<T>> implements Comparable<T> {
    public T value;
    public Node left;
    public Node right;

    public Node(T value) {
        this.value = value;    
    }

    @Override
    public int compareTo(T o) {
        return this.value.compareTo(o);
    }
    
}

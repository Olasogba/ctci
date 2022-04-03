import java.util.ArrayList;

public class MinBinHeap<T extends Comparable<T>> {
    public static void main(String[] args) {
        var s = new MinBinHeap<Integer>();
        // s.insert("I don't k");
        // s.insert("I don't kn");
        // s.insert("I don't kno");
        // s.insert("I don't know");
        // s.insert("I");
        // s.insert("I d");
        // s.insert("I do");
        // s.insert("I don");
        // s.insert("I don'");
        // s.insert("I don't");
        s.insert(1);
        s.insert(3);
        s.insert(4);
        s.insert(-1);
        s.insert(7);
        s.insert(6);
        s.insert(5);
        s.insert(-2);
        s.insert(2);
        s.insert(8);
        s.insert(9);
        s.insert(-3);
        s.insert(-4);

        s.print();
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        s.print();
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
    }

    private ArrayList<T> values = new ArrayList<>();
    private int size = 0;


    // insert(enqueue)
    // remove(dequeue)
    // peek()

    public void insert(T value) {
        values.add(value);

        // bubble up and update size
        bubbleUp(size);
        size++;
    }


    public T remove(int index) {
        var val = this.values.get(index);
        size--;
        swap(index, size);
        sinkDown(index);
        values.remove(size);

        return val;
    }


    public T peek() {
        return this.values.get(0);
    }

    public void print() {
        System.out.println(this.values.toString());
        System.out.println("size: "+this.size);
    }

    private void bubbleUp(int index) {
        if(size==0) return;
        var parent = getParent(index);
        while(index>=0 && values.get(index).compareTo(values.get(parent))<0) {
            swap(index, parent);

            index = parent;

            parent = index/2;
        }
    }


    private void sinkDown(int index) {
        while(true) {
            var left = getLeft(index);
            var right = getRight(index);

            var smallest = left;
            if(right < size && values.get(smallest).compareTo(values.get(right))>0) {
                smallest = right;
            }

            if(smallest>=size || values.get(smallest).compareTo(values.get(index))>0) break;

            swap(index, smallest);

            index=smallest;
        }
    }


    public void swap(int i, int j) {
        var temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }


    public int size() {
        return this.size;
    }


    public int getParent(int index) {
        return (index)/2;
    }

    public int getLeft(int index) {
        return (index * 2);
    }

    public int getRight(int index) {
        return (index * 2) + 1;
    }
}

import java.util.Arrays;

/** Describe how you could use a single array to implement three stacks */
// fixed length stacks, not space efficient

public class ThreeInOneFixed<T> {
    public static void main(String[] args) {
        // divide the array into three fixed lengths
        // use a buffer to store their sizes
        // save the capacity of the array
        // use a sep fun to get the top of a stack
        try {
            var s = new ThreeInOneFixed<>(5, 3);
            s.push(5, 0);
            s.push(6, 0);
            s.push(7, 0);


            s.push(8, 1);
            s.push(9, 1);
            s.push(10, 1);

            
            s.push(11, 2);
            s.push(12, 2);
            s.push(13, 2);
            System.out.println(Arrays.deepToString(s.values));
            s.pop(2);
            System.out.println(Arrays.deepToString(s.values));

        } catch(Exception e) {
            System.out.println(e);
        }

    }

    // push
    // pop
    // peek
    // isEmpty (takes stackNum)

    public T[] values;
    public int[] sizes;
    public int stackCapacity;

    public ThreeInOneFixed(int stackCapacity, int stacks) {
        this.sizes = new int[stacks];
        this.values = (T[]) new Object[stacks * stackCapacity];
        this.stackCapacity = stackCapacity;
    }

    public void push(T value, int stackNum) throws Exception {
        if(isFull(stackNum)) throw new Exception("Stack overflow: stack is full brother");        
        this.sizes[stackNum]++;
        var idx = this.getTopIdxForStack(stackNum);
        this.values[idx]=value;
    }


    public T pop(int stackNum) throws Exception {
        if(this.isEmpty(stackNum)) throw new Exception("Stack is empty!");
        var idx = this.getTopIdxForStack(stackNum);
        var val = this.values[idx];
        this.values[idx] = null;
        this.sizes[stackNum]--;

        return val;
    }



    public T peek(int stackNum) {
        if(this.isEmpty(stackNum)) return null;
        return this.values[getTopIdxForStack(stackNum)];
    }


    public boolean isEmpty(int stackNum) {
        return this.sizes[stackNum]==0;
    }


    private int getTopIdxForStack(int stackNum) {
        var offset = stackNum * stackCapacity;
        return offset+sizes[stackNum]-1;
    }


    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }
}
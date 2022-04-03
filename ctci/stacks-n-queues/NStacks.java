import java.util.Arrays;
import java.util.List;

// Implement N > 0 stacks using a single array to store all stack data. No stack should be
// full unless the entire array is full
// https://www.youtube.com/watch?v=DxW7VAsdX0o

public class NStacks {
    // Solution idea:
    // keep track of the top indexes of each stack
    // update these indexes using a nextIndex array
    // and a nextAvailable variable
 
    int[] topOfStack; // keeps track of the top index of each stack
    int[] stackData; // stores the entire values
    int[] nextIndex; // keeps track of the next index to update for each entry in the stackdata array
 
    int nextAvailable = 0; // keeps track of the next available index
 
    public NStacks(int numStacks, int capacity) {
        topOfStack = new int[numStacks];
        for (int i = 0; i < topOfStack.length; i++) {
            topOfStack[i] = -1;
        }
        stackData = new int[capacity];
        nextIndex = new int[capacity];
        for (int i = 0; i < nextIndex.length - 1; i++) {
            nextIndex[i] = i+1;
        }
        nextIndex[nextIndex.length - 1] = -1;
    }
 
    public void push(int stack, int value) {
        if (stack < 0 || stack >= topOfStack.length) {
            throw new IndexOutOfBoundsException();
        }
 
        if (nextAvailable < 0) return;
 
        int currentIndex = nextAvailable;
        nextAvailable = nextIndex[currentIndex];
        stackData[currentIndex] = value;
        nextIndex[currentIndex] = topOfStack[stack];
        topOfStack[stack] = currentIndex;
    }
 
    public int pop(int stack) {
        if (stack < 0 || stack >= topOfStack.length 
              || topOfStack[stack] < 0) {
            throw new IndexOutOfBoundsException();
        }
 
        int currentIndex = topOfStack[stack];
        int value = stackData[currentIndex];
        topOfStack[stack] = nextIndex[currentIndex]; // or prevIndex
        nextIndex[currentIndex] = nextAvailable;
        nextAvailable = currentIndex;
        return value;
    }

    public static void main(String[] args) {
        var s = new NStacks(5, 25);
        s.push(4, 7);
        s.push(0, 8);
        s.push(4, 9);
        System.out.println(Arrays.toString(s.stackData));
        s.pop(0);
        s.push(0, 2);
        System.out.println(Arrays.toString(s.stackData));
    }
}
 
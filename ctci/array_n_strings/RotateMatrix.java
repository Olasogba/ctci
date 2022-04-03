import java.util.Arrays;



/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

    Input
    [
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12],
        [13,14,15,16]
    ]

    Output
    [
        [13,9,5,1],
        [14,10,6,2],
        [15,11,7,3],
        [16,12,8,4]
    ]
 */

public class RotateMatrix {
    public static void main(String[] args) {
        var matrix = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        // System.out.println(Arrays.deepToString(solve2(matrix)));
        int length = matrix.length;
        // solve2(matrix);
        transpose(matrix);
        reverse(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }


    public static int[][] solve2(int[][] matrix) {
        if (matrix.length== 0 || matrix.length != matrix[0].length) return null; 
        int n = matrix.length; 
        for (int layer = 0; layer < n / 2; layer++) { // swap and keep swapping till you reach the middle
            int first= layer; 
            int last= n - 1 - layer; 
            for(int i = first; i < last; i++) { 
                int offset = i - first;
                int top= matrix[first][i]; // save top 
                // left -> top 
                matrix[first][i] = matrix[last-offset][first]; 
                // bottom -> left 
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom 
                matrix[last][last - offset] = matrix[i][last]; 
                // top -> right 
                matrix[i][last] = top; // right<- saved top 
            }
        }
        return matrix; 
    }


    public static void transpose(int[][] matrix) {
        // convert rows to cols and vice versa
        var n = matrix.length;

        for(var i=0; i<n; i++) {
            for(var j=i; j<n; j++) {
                var temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    public static void reverse(int[][] matrix) {
        var n = matrix.length;
        for(var i=0; i<n; i++) {
            for(var j=0; j<n/2; j++) {
                var temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    
    public static int[][] solve(int[][] matrix) {
        // find the four corners of the matrix and rotate to the right
        // repeat this operation for 1/2 n
        var n = matrix.length;
        for(var i=0; i<n/2; i++) {
            for(var j=i; j<n-i-1; j++) { // inner items
                var temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }


        return matrix;
    }
}

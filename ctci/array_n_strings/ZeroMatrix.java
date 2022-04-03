/**
 *  Write an algorithm such that if an element in an MxN matrix is 0, its entire row and 
    column are set to 0 
 */

/**
 * Space optimization: ctci, page 205
 */
import java.util.ArrayList;
import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
		var matrix = new int[][] {{1,2,3,4,6}, {5,6,7,8,6}, {9,10,11,12,6}, {13,14,15,16,6}, {1,2,3,4,0}};
		solve(matrix);
		System.out.println(Arrays.deepToString(matrix));
    }


    public static void solve(int[][] m) {
        var zeros = new ArrayList<Pair>();
		var n = m[0].length;
		for(var i=0; i<m.length; i++) {
			for(var j=0; j<n; j++) {
				if(m[i][j]==0) zeros.add(new Pair(i, j));
			}
		}
		// ArrayList<Pair> siblingPoints = markSiblings(zeros, n, m.length);
		
		// for(var point : siblingPoints) {
		// 	m[point.i][point.j] = 0;
		// }
		markSiblingsInMatrix(m, zeros);
    }
	
	
	public static ArrayList<Pair> markSiblings(ArrayList<Pair> zeros, Integer cols, Integer rows) {
		var points = new ArrayList<Pair>();
		
		for(var x : zeros) {
			var i = x.i;
			var j = x.j;
			
			var idx1 = 0;
			while(idx1 < cols) {
				points.add(new Pair(i, idx1));
				idx1++;
			}
			
			var idx2 = 0;
			while(idx2 < rows) {
				points.add(new Pair(idx2, j));
				idx2++;
			}
		}
		
		return points;
	}


	public static void markSiblingsInMatrix(int[][] m, ArrayList<Pair> zeros) {
		for(var x: zeros) {
			var cols = m[0].length;
			var rows = m.length;

			var idx1 = 0;
			var idx2 = 0;

			while(idx1 < rows) {
				m[idx1][x.j] = 0;
				idx1++;
			}

			while(idx2 < cols) {
				m[x.i][idx2] = 0;
				idx2++;
			}
		}
	}
	
	
	
	public static void solve2(int[][] m) {
        
    }
	
	
	static class Pair {
		private final Integer i;
		private final Integer j;
		Pair(Integer x, Integer y) {
			i=x;
			j=y;
		}
		@Override
        public String toString() {
            return "{"+ i + ", " + j +"}";
        }
	}
}


public class RingPatternCodingNinja {
	private static void printPattern(int n) {
		int[][] mat = buildPattern(n);
		
		int dim = mat.length;
		for(int i = 0;i<dim;i++) {
			for(int j = 0;j<dim;j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static int[][] buildPattern(int n) {
		int nDim = 2 * n - 1;
		int[][] mat = new int[nDim][nDim];

		int top = 0;
		int bottom = nDim - 1;
		int left = 0;
		int right = nDim - 1;

		int startCol = 0;
		int endCol = nDim;
		int startRow = 0;
		int endRow = nDim;
		int temp = n;
		for (int i = 0; i < n; i++) {
			for (int col = startCol; col < endCol; col++) {
				mat[top][col] = temp;
			}
			for (int col = startCol; col < endCol; col++) {
				mat[bottom][col] = temp;
			}
			for (int row = startRow; row < endRow; row++) {
				mat[row][left] = temp;
			}
			for (int row = startRow; row < endRow; row++) {
				mat[row][right] = temp;
			}
			temp--;
			top++;
			bottom--;
			left++;
			right--;
			startCol++;
			endCol--;
			startRow++;
			endRow--;
		}
		return mat;
	}

	public static void main(String[] args) {
		printPattern(5);
	}

}

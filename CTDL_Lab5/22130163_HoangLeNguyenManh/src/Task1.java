import java.util.Arrays;

public class Task1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int[][] addMatrix = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				addMatrix[i][j] = a[i][j] + b[i][j];
			}
		}
		return addMatrix;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		int[][] subtractMatrix = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				subtractMatrix[i][j] = a[i][j] - b[i][j];
			}
		}
		return subtractMatrix;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] multiplyMatrix = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					multiplyMatrix[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return multiplyMatrix;
	}

	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] tranposeMatrix = new int[a[0].length][a.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				int temp = a[i][j];
				a[i][j] = tranposeMatrix[j][i];
				tranposeMatrix[j][i] = temp;

			}
		}
		return tranposeMatrix;
	}

	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 } };
		int[][] b = { { 2, 1 }, { 3, 1 } };
		
		// test add
		int[][] addMatrix = add(a, b);
		System.out.println("add Matrix: " + Arrays.deepToString(addMatrix));
		
		// test subtract
		int[][] subtractMatrix = subtract(a, b);
		System.out.println("subtract Matrix: " + Arrays.deepToString(subtractMatrix));
		
		// test multiply
		int[][] c = { { 1, 2, 3, 7 }, { 4, 5, 6, 8 } };
		int[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int[][] multiplyMatrix = multiply(c, d);
		System.out.println("multiply Matrix: " + Arrays.deepToString(multiplyMatrix));
		
		// test transpose
		int[][] e = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int[][] transposeMatrix = transpose(e);
		System.out.println("transpose Matrix: " + Arrays.deepToString(transposeMatrix));
	}
}

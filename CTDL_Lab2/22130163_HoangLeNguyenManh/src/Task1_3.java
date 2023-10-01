
public class Task1_3 {
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			// in khoảng trống để định dạng
			for (int j = 0; j < row - i; j++) {
				System.out.print(" ");
			}
			// Lấy các phần tử của hàng và in ra
			int[] currentRow = getPascalTriangle(i);
			for (int num : currentRow) {
				System.out.print(num + " ");
			}
			System.out.println(); // Move to the next line for the next row
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[0];
		} else {
			int[] prevRow = getPascalTriangle(n - 1); // tạo mảng prevRow chứa các phần tử khi n != 1
			return generateNextRow(prevRow); // bỏ vào methoh generateNextRow để tạo ra các hàng tiếp theo
		}
	}

	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	// create NextRow
	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		int numRows = 10; // Số dòng muốn in ra tam giác Pascal
		printPascalTriangle(numRows);
	}
}


public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkRows() {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
				return true; // Có một hàng được đánh đầy bởi một người chơi
			}
		}
		return false; // Không có hàng nào được đánh đầy bởi một người chơi
	}

	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */
	public boolean checkColumns() {
		for (int column = 0; column < 3; column++) {
			if (board[0][column] == board[1][column] && board[0][column] == board[2][column]) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkDiagonals() {
		// Check top-left to bottom-right
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return true;
		}
		// Check bottom-left to top-right
		if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		// Tạo một đối tượng TicTacToe
		TicTacToe ticTacToe = new TicTacToe();

		// Khởi tạo bảng với một ví dụ của trò chơi Tic-Tac-Toe
		char[][] board = { { 'X', 'O', 'X' }, 
				           { 'O', 'X', 'O' }, 
				           { 'X', 'O', 'X' } };
		ticTacToe.board = board;

		// Kiểm tra hàng
		if (ticTacToe.checkRows()) {
			System.out.println("Có người chiến thắng theo hàng.");
		} else {
			System.out.println("Không có người chiến thắng theo hàng.");
		}

		// Kiểm tra cột
		if (ticTacToe.checkColumns()) {
			System.out.println("Có người chiến thắng theo cột.");
		} else {
			System.out.println("Không có người chiến thắng theo cột.");
		}

		// Kiểm tra đường chéo
		if (ticTacToe.checkDiagonals()) {
			System.out.println("Có người chiến thắng theo đường chéo.");
		} else {
			System.out.println("Không có người chiến thắng theo đường chéo.");
		}
	}
}

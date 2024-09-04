package Task3;

import java.util.Scanner;

public class SCT_SD_TASK_3 {

	private static final int SIZE = 9;

	public static void main(String[] args) {
		int[][] board = new int[SIZE][SIZE];
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Sudoku puzzle row by row.");
		System.out.println("Use 0 for empty cells.");
		for (int i = 0; i < SIZE; i++) {
			System.out.print("Enter row " + (i + 1) + " (9 digits with spaces): ");
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = scanner.nextInt();
			}
		}

		System.out.println("\nSolving the puzzle...");

		if (solveSudoku(board)) {
			System.out.println("Sudoku puzzle solved successfully:");
			printBoard(board);
		} else {
			System.out.println("No solution exists for the given Sudoku puzzle.");
		}

		scanner.close();
	}

	private static boolean solveSudoku(int[][] board) {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (board[row][col] == 0) {
					for (int num = 1; num <= 9; num++) {
						if (isValid(board, row, col, num)) {
							board[row][col] = num;
							if (solveSudoku(board)) {
								return true;
							}
							board[row][col] = 0; 
						}
					}
					return false; 
				}
			}
		}
		return true; 
	}

	private static boolean isValid(int[][] board, int row, int col, int num) {
		for (int i = 0; i < SIZE; i++) {
			if (board[row][i] == num || board[i][col] == num
					|| board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
				return false;
			}
		}
		return true;
	}

	private static void printBoard(int[][] board) {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}
}

package leet.Array;

import java.util.HashMap;

public class Solution10 {

	public boolean isValidSudoku2(char[][] board) {

		// check each column
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}

		// check each row
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}

		// check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (m[(int) (board[i][j] - '1')]) {
							return false;
						}
						m[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}

		return true;
	}

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length == 0)
			return false;
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		HashMap<Integer, Integer>[] cols = new HashMap[9];
		HashMap<Integer, Integer>[] boxes = new HashMap[9];

		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			cols[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}

		int num = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char n = board[i][j];
				if (board[i][j] != '.') {
					num = (int) n;
					int box_index = (i / 3) * 3 + j / 3;
					rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
					cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
					boxes[box_index].put(num, boxes[box_index].getOrDefault(num, 0) + 1);

					if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxes[box_index].get(num) > 1)
						return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution10 s = new Solution10();

		char[][] input = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		boolean res = s.isValidSudoku(input);

		System.out.println("==========");
		System.out.printf("RES: %B", res);
	}

}

package leet.String;

import java.util.ArrayList;

public class Solution2 {

	public int reverse(int x) {

		try {
			char[] input = Integer.toString(x).toCharArray();

			int start = 0;
			int end = input.length - 1;

			boolean sign = true; // true: +, false : -
			if (input[start] == '-') {
				sign = false;
				start++;
			}

			int length = input.length - start;
			for (int i = 0; i < length / 2; i++) {
				char temp = input[i + start];
				input[i + start] = input[end - i];
				input[end - i] = temp;
			}

			String answer = new String();
			for (int i = start; i <= end; i++) {
				answer += input[i];
			}

			if (sign) {
				return Integer.parseInt(answer);
			} else {
				return -(Integer.parseInt(answer));
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public int reverse2(int x) {

		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		int input = -43210;
		int res = solution.reverse2(input);

		System.out.println("IN: " + input);
		System.out.println("OUT: " + res);

	}

}

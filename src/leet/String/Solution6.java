package leet.String;

public class Solution6 {

	public int myAtoi(String str) {

		str = str.trim().toLowerCase();
		String num = "";

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			int currentNum = (int) currentChar - '0';

			if (num.length() == 0) {
				if (currentChar == '-' || currentChar == '+' || (currentNum >= 0 && currentNum <= 9)) {
					// 부호, 숫자
					num += currentChar;
				} else {
					return 0;
				}
			} else {
				if (currentNum >= 0 && currentNum <= 9) {
					// 숫자
					num += currentChar;
				} else {
					break;
				}
			}
		}

		try {
			return (int) Double.parseDouble(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution6 solution = new Solution6();

//		int res = solution.myAtoi("42"); // 42
//		int res = solution.myAtoi("   -42"); // -42
//		int res = solution.myAtoi("4193 with words"); // 4193
//		int res = solution.myAtoi("words and 987"); // 0
//		int res = solution.myAtoi("-91283472332"); // -2147483648
//		int res = solution.myAtoi("3.14159"); // 3
//		int res = solution.myAtoi("  -0012a42"); // -12
//		int res = solution.myAtoi("   +0 123"); // 0
		int res = solution.myAtoi("-5-"); // -5

		System.out.println();
		System.out.println("RES: " + res);
	}
}

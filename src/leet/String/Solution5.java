package leet.String;

public class Solution5 {

	public boolean isPalindrome(String s) {

		s = s.toLowerCase();

		int count = 0;
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			char pre = s.charAt(i);
			char post = s.charAt(j);
			boolean preIAlphanumeric = ((int) pre > 96 && (int) pre < 123) || ((int) pre > 47 && (int) pre < 58);
			boolean postIsAlphanumeric = ((int) post > 96 && (int) post < 123) || ((int) post > 47 && (int) post < 58);

			if (!preIAlphanumeric)
				i++;
			if (!postIsAlphanumeric)
				j--;

			if (preIAlphanumeric && postIsAlphanumeric) {
//				System.out.printf("[%2d] %2c \t[%2d] %2c \t... %b\n", i, pre, j, post, pre == post);
				if (!(pre == post))
					return false;
				i++;
				j--;
				count++;
			}
		}

//		System.out.println("i: " + i + ", j: " + j + ", count: " + count);
		if (count > 0) {
			return true;
		} else if (count == 0) {
			if (i > j)
				return true;
		}
		return false;
	}

	public boolean isPalindrome2(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (i < j && !isLetterOrDigit(s.charAt(i))) {
				i++;
			}

			while (i < j && !isLetterOrDigit(s.charAt(j))) {
				j--;
			}

			if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j)))
				return false;
		}

		return true;
	}

	public boolean isPalindrome3(String s) {
		if (s.isEmpty()) {
			return true;
		}
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		while (head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
		}

		return true;
	}

	private static boolean isLetterOrDigit(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

	private static char toLowerCase(char c) {
		return (c >= 'a' && c <= 'z') ? c : (char) (c - 'A' + 'a');
	}

	public static void main(String[] args) {
		Solution5 solution = new Solution5();

//		boolean res = solution.isPalindrome("A man, a plan, a canal: Panama"); // result: true
//		boolean res = solution.isPalindrome("race a car"); // result: false
//		boolean res = solution.isPalindrome("0P"); // result: false
//		boolean res = solution.isPalindrome(""); // result: true
//		boolean res = solution.isPalindrome(" "); // result: true
		boolean res = solution.isPalindrome("a"); // result: true

		System.out.println("RES: " + res);
	}

}

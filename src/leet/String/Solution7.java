package leet.String;

public class Solution7 {

	public int strStr(String haystack, String needle) {
		
		if (haystack == needle || needle.length() == 0) {
			return 0;
		}

		if (haystack.length() >= needle.length()) {
			int i = 0;
			int j = 0;
			
			while (i < haystack.length()) {
				System.out.printf("h[%d]: %c, n[%d]: %c \n", i, haystack.charAt(i), j, needle.charAt(j));
				// haystack에서 needle의 첫번째 문자와 일치하는게 있는지 확인
				if (haystack.charAt(i) == needle.charAt(j)) {
					if (j == needle.length() -1) {
						return i;
					}
					j++;

					boolean check = false;
					while (j < needle.length() && (i + j) < haystack.length()) {
						System.out.printf("\t\t h[%d]: %c, n[%d]: %c \n",
								i + j, haystack.charAt(i + j),
								j, needle.charAt(j));
						// neddle의 모든 문자와 일치하는지 확인
						if (haystack.charAt(i + j) == needle.charAt(j)) {
							if (j == needle.length() - 1) {
								System.out.println("\t\t 모두 일치");
								check = true;
								return i;
							}
							j++;
						} else {
							System.out.println("\t\t 틀려");
							check = false;
							break;
						}
					}
					
					if (check) {
						return i;
					} else {
						i++;
						j = 0;
					}
				} else {
					i++;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution7 solution = new Solution7();

//		int res = solution.strStr("hello", "ll"); // 2
//		int res = solution.strStr("hellxx", "llo"); // 2
//		int res = solution.strStr("aaaaa", "bba"); // -1
//		int res = solution.strStr("", "a"); // -1
//		int res = solution.strStr("", ""); // 0
//		int res = solution.strStr("a", ""); // 0
//		int res = solution.strStr("a", "a"); // 0
//		int res = solution.strStr("aaa", "aaaa"); // -1
//		int res = solution.strStr("mississippi", "issip"); // 4
//		int res = solution.strStr("mississippi", "issipi"); // -1
		int res = solution.strStr("mississippi",  "sipp"); // 6

		System.out.println();
		System.out.println("RES: " + res);
	}

}

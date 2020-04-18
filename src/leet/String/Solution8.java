package leet.String;

public class Solution8 {

	public String countAndSay(int n) {

		int i = 1;
		String str = Integer.toString(i);

		while (i < n) {
//			System.out.printf("%d. str = %s \n", i, str);
			int j = str.length() - 1;
			char pivot = str.charAt(j);
			char curr = str.charAt(j);
			int count = 0;
			String result = "";

			while (j >= 0) {
				curr = str.charAt(j);
				if (curr == pivot) {
					count++;
				} else {
					result = Integer.toString(count) + pivot + result;
					pivot = curr;
					count = 1;
				}
				j--;
			}
			
			if (curr == pivot) {
				result = Integer.toString(count) + curr + result;
			} else {
				result = Integer.toString(count) + curr + result;
			}
			
			str = result;
			
			i++;
		}

		return str;
	}

	public static void main(String[] args) {
		Solution8 solution = new Solution8();

//		int i = 8;
		for (int i = 1; i <= 10; i++) {
		System.out.printf("input: %2d \toutput: %20s \n", i, solution.countAndSay(i));
		}

	}

}

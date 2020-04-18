package leet.String;

public class Solution9 {

	public String longestCommonPrefix(String[] strs) {
		
		if (strs == null || strs.length == 0) return "";
		if (strs.length <= 1) return strs[0];
		
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {

			if (minLength > strs[i].length()) {
				minLength = strs[i].length();
			}
		}
	
		String result = "";
		for (int i = 0; i < minLength; i++) {
			
			char pivot = strs[0].charAt(i);
			
			for (int j=1; j< strs.length; j++) {
				if (pivot == strs[j].charAt(i)) {
					if (j == strs.length-1) {
						result += pivot;
					}
				} else {
					return result;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution9 solution = new Solution9();

		String[] input = { "flower", "flow", "flight" }; // res: "fl"
//		String[] input = { "dog", "racecar", "car" }; // res: ""
//		String[] input = { "dog", "rog", "cog" }; // res: ""
//		String[] input = { "a" }; // res: "a"
		

		String res = solution.longestCommonPrefix(input);
		System.out.println("RES: \"" + res + "\"");
	}
}

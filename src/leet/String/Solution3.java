package leet.String;

import java.util.LinkedHashMap;

public class Solution3 {

	public int firstUniqChar(String s) {

		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			int value = map.get(s.charAt(i));
			if (value == 1) {
				return i;
			}
		}

		return -1;
	}

	public int firstUniqChar2(String s) {
		int counts[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			counts[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (counts[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();

//		int res = solution.firstUniqChar("leetcode"); // result: 0
//		int res = solution.firstUniqChar("loveleetcode"); // result: 2
		int res = solution.firstUniqChar("dddccdbba"); // result: 8

		System.out.println("RES: " + res);
	}

}

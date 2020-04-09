package leet.String;

import java.util.HashMap;

public class Solution4 {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if (map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
			} else {
				return false;
			}
		}

		for (char key : map.keySet()) {
			int value = map.get(key);
			if (value != 0) {
				return false;
			}
		}

		return true;
	}
	
	public boolean isAnagram2(String s, String t) {
		int[] counts = new int[26];
		for (int i = 0; i < s.length(); i++)
			counts[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			counts[t.charAt(i) - 'a']--;
		for (int i : counts)
			if (i != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Solution4 solution = new Solution4();

//		boolean res = solution.isAnagram("anagram", "nagaram"); // result: true
//		boolean res = solution.isAnagram("rat", "car"); // result: false
		boolean res = solution.isAnagram("aacc", "ccac"); // result: false

		System.out.println("RES: " + res);
	}

}

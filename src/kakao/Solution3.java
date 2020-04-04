package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution3 {

	public int solution1(String[] user_id, String[] banned_id) {
		/*
		 * } int answer = 0; int[] count = new int[banned_id.length]; //
		 * ArrayList<Integer> cnt = new ArrayList<Integer>();
		 * 
		 * for (int i = 0; i < banned_id.length; i++) {
		 * System.out.println(banned_id[i]); banned_id[i] =
		 * banned_id[i].replaceAll("[*]", "."); // cnt.add(i, 0); }
		 * System.out.println("==========");
		 * 
		 * for (int i = 0; i < banned_id.length; i++) { String banned = banned_id[i];
		 * for (String user : user_id) { if (banned.length() == user.length()) {
		 * 
		 * Pattern pattern = Pattern.compile(banned); Matcher matcher =
		 * pattern.matcher(user);
		 * 
		 * if (matcher.matches()) { System.out.printf("%-10s %-10s\n", banned, user);
		 * count[i]++; // cnt.set(i, cnt.get(i) + 1); } } } }
		 */

//		cnt.add(0);
//		cnt.add(0);
//		cnt.remove(new Integer(0));
//		System.out.println("==========");
//
//		for (int i = 0; i < cnt.size(); i++) {
//			System.out.printf("[%d] %d\n", i, cnt.get(i));
//		}

		int answer = 0;

		ArrayList<String> banned_list = new ArrayList<String>();
		ArrayList<String> remove_list = new ArrayList<String>();
		ArrayList<String> user_list = new ArrayList<>(Arrays.asList(user_id));

		// 1. 중복된 값 찾기
		for (String id : banned_id) {
			if (!banned_list.contains(id)) {
				banned_list.add(id);
			} else {
				remove_list.add(id);
			}
		}
		System.out.println("==========");

		// 2. 중복된 값 삭제
		for (String id : remove_list) {
			banned_list.remove(id);
		}

		for (String id : banned_list) {
			System.out.println(id);
		}
		System.out.println("==========");

		// 3. 조합 찾기
		for (int i = 0; i < banned_list.size(); i++) {
			String banned = banned_list.get(i);
			for (int j = 0; j < user_id.length; j++) {
				String user = user_id[j];
				if (banned.length() == user.length()) {
					Pattern pattern = Pattern.compile(banned.replaceAll("[*]", "."));
					Matcher matcher = pattern.matcher(user);

					if (matcher.matches()) {
						System.out.printf("[%d] %-10s [%d] %-10s\n", i, banned, j, user);
					}
				}
			}
//			for (String user : user_id) {
//				if (banned.length() == user.length()) {
//
//					Pattern pattern = Pattern.compile(banned.replaceAll("[*]", "."));
//					Matcher matcher = pattern.matcher(user);
//
//					if (matcher.matches()) {
//						System.out.printf("[%d] %-10s %-10s\n", i, banned, user);
//					}
//				}
//			}
		}

		System.out.println("==========");
//		for (int i = 0; i < count.length; i++) {
//			System.out.printf("[%d] %d\n", i, count[i]);
//		}

//		System.out.printf(">> %d", result);

		return answer;
	}

	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;

		// 1. 매칭하기
		ArrayList<ArrayList<Integer>> groupList = null;
		ArrayList<Integer> childList = null;
		groupList = new ArrayList<ArrayList<Integer>>();
		childList = new ArrayList<Integer>();

		for (String banned : banned_id) {
			childList = new ArrayList<Integer>();
			for (int i = 0; i < user_id.length; i++) {
				if (banned.length() == user_id[i].length()) {
					Pattern pattern = Pattern.compile(banned.replaceAll("[*]", "."));
					Matcher matcher = pattern.matcher(user_id[i]);

					if (matcher.matches()) {
						childList.add(i);
					}
				}
			}
			if (!groupList.contains(childList)) {
				groupList.add(childList);
			}
		}

		for (int i = 0; i < groupList.size(); i++) {
			System.out.printf("[%d] ", i);
			for (int j : groupList.get(i)) {
				System.out.printf("%d ", j);
			}
			System.out.println();
		}
		System.out.println("==========");

		// 2. 조합찾기
		boolean result = false;
		for (int i = 0; i < groupList.size(); i++) {
			ArrayList<Integer> list = groupList.get(i);
			for (int j = 0; j < groupList.get(i).size(); j++) {
				System.out.printf("[%d] %d \n", i, list.get(j));
				int pivot = j;
				result = recursion(groupList, i+1, pivot);
			}
			System.err.println(result);
			System.out.println("----------");
		}
		
		

		return answer;
	}

	public boolean recursion(ArrayList<ArrayList<Integer>> groupList, int start, int pivot) {

		for (int i = start; i < groupList.size(); i++) {
			ArrayList<Integer> list = groupList.get(i);
			for (int j = 0; j < groupList.get(i).size(); j++) {
				if (list.get(j) == pivot) {
					continue;
				} else {
					System.out.printf("\t[%d] %d \n", i, list.get(j));
					recursion(groupList, i+1, list.get(j));
				}
			}
			System.out.println();
		}

		return false;
	}

	public void printArray(ArrayList<ArrayList<Integer>> groupList) {
		for (int i = 0; i < groupList.size(); i++) {
			ArrayList<Integer> list = groupList.get(i);
			for (int j = 0; j < groupList.get(i).size(); j++) {
				System.err.printf("[%d] %d \n", i, list.get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Solution3 s = new Solution3();

//		String[] user_id = new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" };
//		String[] banned_id = new String[] { "fr*d*", "abc1**" };
		// result 2

//		String[] user_id = new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" };
//		String[] banned_id = new String[] { "*rodo", "*rodo", "******" };
		// result 2

		String[] user_id = new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = new String[] { "fr*d*", "*rodo", "******", "******" };
		// result 3

		int res = s.solution(user_id, banned_id);

		System.out.println("");
		System.out.printf("RES: %d", res);
	}

}

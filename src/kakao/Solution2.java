package kakao;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {

	public int[] solution(String input) {
		int[] answer = {};

		// 1. String 잘라서 ArrayList로 만들기
		Pattern pattern = Pattern.compile("(\\d+,?)+");
		Matcher matcher = pattern.matcher(input);

		ArrayList<ArrayList<Integer>> groupList = null;
		ArrayList<Integer> childList = null;

		groupList = new ArrayList<ArrayList<Integer>>();
		childList = new ArrayList<Integer>();

		while (matcher.find()) {
			String[] string = matcher.group().split(",");
			
			childList = new ArrayList<Integer>();
			for (String s : string) {
				childList.add(Integer.parseInt(s));
			}
			groupList.add(childList);
		}

		// 2. 길이순으로 탐색할 순서 찾기
		int[] order = new int[groupList.size()];

		for (int i = 0; i < groupList.size(); i++) {
			for (int value : groupList.get(i)) {
			}
			order[groupList.get(i).size() - 1] = i;
		}

		// 3. 요소 찾기
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : order) {
			for (Integer value : groupList.get(i)) {
				if (!list.contains(value)) {
					list.add(value);
				}
			}
		}

		// 4. 반환
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();

//		String input = "{{2},{2,1},{2,1,3},{2,1,3,4}}";	// [2, 1, 3, 4]
//		String input = "{{1,2,3},{2,1},{1,2,4,3},{2}}";	// [2, 1, 3, 4]
		String input = "{{20,111},{111}}";				// [111, 20]
//		String input = "{{123}}";						// [123]
//		String input = "{{4,2,3},{3},{2,3,4,1},{2,3}}";	// [3, 2, 4, 1]

		int[] res = s.solution(input);

		System.out.println("");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + ", ");
		}

	}

}

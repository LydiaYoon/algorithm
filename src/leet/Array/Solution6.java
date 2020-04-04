package leet.Array;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution6 {

	public int[] intersect(int[] nums1, int[] nums2) {

		// 1. nums1 체크
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
				// 이미 가지고 있는 키라면 값만 1 증가
			} else {
				map.put(i, 1);
				// 처음 체크한 키라면 값을 1로 저장
			}
		}

		// 2. nums2 체크
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : nums2) {
			if (map.containsKey(i)) {
				if (map.get(i) > 1) {
					map.put(i, map.get(i) - 1);
					// 값이 1 이상 경우 (nums1에 같은 키가 여러개 있었을 경우)
					// 값 1 감소
				} else {
					map.remove(i);
				}
				list.add(i);
			}
		}

		// 3. ArrayList에서 Array로 바꾸기
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		Solution6 s = new Solution6();

		int[] res;

		int[] nums1 = new int[] { 1, 2, 2, 1 };
		int[] nums2 = new int[] { 2, 2 };
//		int[] nums1 = new int[] { 4, 9, 5 };
//		int[] nums2 = new int[] { 9, 4, 9, 8, 4 };
		res = s.intersect(nums1, nums2);

		System.out.println("==========");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + " ");
		}

	}

}
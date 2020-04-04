package leet.Array;

import java.util.HashMap;
import java.util.Map;

public class Solution9 {

	public int[] twoSum(int[] nums, int target) {
		/*
		int[] result = null;
		
		for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
	            if (nums[i] + nums[j] == target) {
	                result = new int[] { i, j };
	            }
	        }
	    }
		return result;
		*/
		
		int[] result = { -1, -1 };
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			
			int complement = target - nums[i]; // target의 보수
			
			if (!map.containsKey(nums[i])) { 
				map.put(complement, i); // 인덱스의 보수와 인덱스를 map에 저장
			} else { // 현재 값이 map에 있다면 , 그 값은 현재 값의 보수임 
				return new int[] { map.get(nums[i]), i }; // map에 저장했던 보수의 인덱스와 현재 값을 리턴 
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		Solution9 s = new Solution9();

		int[] res;

		res = s.twoSum(new int[] { 2, 7, 11, 15 }, 9);
//		res = s.twoSum(new int[] { 2, 7, 11, 15 }, 22);

		System.out.println("==========");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}

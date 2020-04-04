package leet.Array;

public class Solution8 {

	public void moveZeroes(int[] nums) {

		int index = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[index++] = num; // // 0이 아닌 다른 숫자를 앞으로 옮긴다
			}
		}

		while (index < nums.length) {
			nums[index++] = 0; // 배열의 길이까지 남은 인덱스를 0으로 채운다.
		}
	}

	public static void main(String[] args) {
		Solution8 s = new Solution8();

//		int[] res = new int[] { 0, 1, 0, 3, 12 };
		int[] res = new int[] { 0, 1, 0, 6, 3, 1, 1, 4, 0, 9, 6 };

		
		s.moveZeroes(res);

		System.out.println("==========");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + " ");
		}

	}

}

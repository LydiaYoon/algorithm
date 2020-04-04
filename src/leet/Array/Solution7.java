package leet.Array;

public class Solution7 {

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return new int[0];

		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			// 1의 자리부터 탐색 (배열 뒤에서부터 앞으로 탐색)
			int sum = digits[i] + carry;
			if (sum >= 10) {
				carry = 1;
				// 합이 10을 넘으면 1을 올린다.
			} else {
				carry = 0;
				// 합이 10을 넘지 않으면 올리지 않는다.
			}
			digits[i] = sum % 10;
			// 현재 자릿수에서 1을 더한 값의 1의 자리 숫자를 저장한다.
		}

		if (carry == 1) {
			// 마지막 자릿수까지 계산한 후 올림값이 1이라면 자릿수가 추가되어야함
			int[] result = new int[digits.length + 1];
			System.arraycopy(digits, 0, result, 1, digits.length);
			// 배열 길이만 한 개 늘려서 그대로 복사한 후
			result[0] = 1;
			// 첫번째 값을 1로 저장.
			return result;
		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		Solution7 s = new Solution7();

		int[] res;

		res = s.plusOne(new int[] { 1, 2, 3 });
//		res = s.plusOne(new int[] { 9, 9, 9 });

		System.out.println("==========");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + " ");
		}

	}

}
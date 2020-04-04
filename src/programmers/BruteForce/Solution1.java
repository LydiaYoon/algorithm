package programmers.BruteForce;

public class Solution1 {

	public void printScore(int[] score) {
		for (int i : score) {
			System.out.printf("%d ", i);
		}
		System.out.println("");
	}

	public int[] solution(int[] answers) {
		int[] result = {};
		int[] score = new int[3];
		int[][] persons = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		int personIndex = 0;
		int answerIndex = 0;

		// 점수 매기기
		for (int answer : answers) {
			for (int[] person : persons) {
				if (answer == person[answerIndex % person.length]) {
					score[personIndex]++;
				}
				personIndex++;
			}
			personIndex = 0;
			answerIndex++;
		}

		// 순위 구하기
		int[] rank = new int[3];
		for (int i = 0; i < score.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < score.length; j++) {
				if (i == j) {
					continue;
				}
				if (score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		
		// 1위 찾기
		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == 1) {
				int[] tempResult = result;
				int[] temp = { i + 1 };
				result = new int[tempResult.length + temp.length];

				System.arraycopy(tempResult, 0, result, 0, tempResult.length);
				System.arraycopy(temp, 0, result, tempResult.length, temp.length);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();

		int[] res;
//		res = s.solution(new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4 });
//		res = s.solution(new int[] { 1, 2, 3, 4, 5 });
//		res = s.solution(new int[] { 1, 3, 2, 4, 2 });
//		res = s.solution(new int[] { 3, 3, 1, 3, 2 });
//		res = s.solution(new int[] { 2, 1, 2, 1, 2 });
		res = s.solution(new int[] { 3, 3, 2, 3, 2 });

		System.out.println("");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}

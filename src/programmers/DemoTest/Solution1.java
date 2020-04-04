package programmers.DemoTest;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution1 {

	public int[] solution(int[][] v) {
		int[] answer = {};

		ArrayList<Integer> list[] = new ArrayList[2];
		list[0] = new ArrayList<Integer>();
		list[1] = new ArrayList<Integer>();

		for (int[] position : v) {
			for (int i = 0; i < position.length; i++) {
				Integer p = position[i];
				if (!list[i].contains(p)) {
					list[i].add(p);
				} else {
					list[i].remove(p);
				}
			}
		}

		answer = new int[] { list[0].get(0), list[1].get(0) };
		return answer;
	}

	public static void main(String[] args) {

		Solution1 s = new Solution1();

//		int[][] input = { { 1, 4 }, { 3, 4 }, { 3, 10 } }; // {1, 10}
		int[][] input = { { 1, 1 }, { 2, 3 }, { 1, 2 } }; // {2, 1}

		int[] res = s.solution(input);

		System.out.println("");
		System.out.print("RES: ");

		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}

/*
직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.

제한사항
v는 세 점의 좌표가 들어있는 2차원 배열입니다.
v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
좌표값은 1 이상 10억 이하의 자연수입니다.
직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
입출력 예
v	result
[[1, 4], [3, 4], [3, 10]]	[1, 10]
[[1, 1], [2, 2], [1, 2]]	[2, 1]
입출력 예 설명
입출력 예 #1
세 점이 [1, 4], [3, 4], [3, 10] 위치에 있을 때, [1, 10]에 점이 위치하면 직사각형이 됩니다.

입출력 예 #2
세 점이 [1, 1], [2, 2], [1, 2] 위치에 있을 때, [2, 1]에 점이 위치하면 직사각형이 됩니다.
*/



/*
이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

제한 조건
n과 m은 각각 1000 이하인 자연수입니다.
예시
입력

5 3
출력

*****
*****
*****
 */
package naver;

/*
[문제 설명]
숫자 블록으로 이루어진 피라미드가 있습니다. 각 블록에는 숫자가 적혀있는데, 어떤 블록의 값은 바로 아래에 맞닿아 있는 두 블록의 값을 합한 값입니다. 피라미드의 일부 블록 값이 주어졌을 때 전체 피라미드 구성을 알아내려고 합니다.

아래 그림은 피라미드를 구성하는 일부 블록의 값을 나타냅니다.
// example0_start.png

각 층마다 적어도 하나의 블록 값을 알기 때문에 다음과 같이 모든 피라미드의 블록 값을 알아낼 수 있습니다.
// example0_end.png

피라미드의 꼭대기 층인 0행부터 마지막 행까지 순서대로, 각 행을 구성하는 블록들 중 하나에 대한 정보를 나타내는 2차원 배열 blocks가 매개변수로 주어집니다. 피라미드를 완성시킨 후, 꼭대기 층부터 제일 아래층까지 순서대로 모두 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

[제한사항]
blocks의 길이는 1 이상 15 이하입니다.
blocks의 i번째 원소는 피라미드 i행을 구성하는 블록 하나에 대한 정보입니다.
blocks의 원소는 [a, b] 형식입니다.
a는 왼쪽에서 몇 번째 블록인지를 나타내며(맨 왼쪽의 블록이 0번째 블록입니다), i행의 경우 0 이상 i 이하의 정수입니다.
b는 블록의 값을 나타내며, -100 이상 100 이하의 정수입니다.

[입출력 예]
blocks	result
[[0, 50], [0, 22], [2, 10], [1, 4], [4, -13]]	[50, 22, 28, 4, 18, 10, 0, 4, 14, -4, 1, -1, 5, 9, -13]
[[0, 92], [1, 20], [2, 11], [1, -81], [3, 98]]	[92, 72, 20, 63, 9, 11, 144, -81, 90, -79, 217, -73, -8, 98, -177]

[입출력 예 설명]
입출력 예 #1
문제 예시와 같습니다.

입출력 예 #2
아래 그림과 같이 피라미드를 채울 수 있습니다.
// example1_end.png
 */

import java.util.Objects;

public class Solution2 {
    public int[] solution(int[][] blocks) {
        if (Objects.isNull(blocks)) {
            throw new IllegalArgumentException("blocks가 비어있습니다.");
        }

        if (blocks.length < 1 || blocks.length > 15) {
            throw new IllegalArgumentException("blocks의 길이는 1 이상 15 이하 이어야 합니다.");
        }

        int length = fibonacciIndex(1, blocks.length);

        int[] answer = new int[length];

        for (int row = 0; row < blocks.length; row++) {
            int fibo = fibonacciIndex(1, row);
            int[] block = blocks[row];
            answer[block[0] + fibo] = block[1];
        }


        // 자식 노드 계산하기
        for (int row = 0; row < blocks.length - 1; row++) {

            int fibo = fibonacciIndex(1, row);
            int nextFibo = fibonacciIndex(1, row + 1);

//            System.out.printf("\n[%d, %d]\n", row, fibo);

            for (int index = 0; index <= row; index++) {
                int currentIndex = index + fibo;
                int leftChildIndex = index + nextFibo;
                int rightChildIndex = index + nextFibo + 1;
                System.out.printf("[%d] %d\n", currentIndex, answer[currentIndex]);
                System.out.printf("\t[%d] %d", leftChildIndex, answer[leftChildIndex]);
                System.out.printf("\t[%d] %d\n", rightChildIndex, answer[rightChildIndex]);

                if (answer[leftChildIndex] + answer[rightChildIndex] == answer[currentIndex]) {
                    continue;
                }
                if (answer[leftChildIndex] == 0 && answer[rightChildIndex] == 0) {
                    // 자식 둘 다 0일 경우
                }
                if (answer[leftChildIndex] == 0 && answer[rightChildIndex] != 0) {
                    // 왼쪽 자식이 0일 경우
                    answer[leftChildIndex] = answer[currentIndex] - answer[rightChildIndex];
                }
                if (answer[leftChildIndex] != 0 && answer[rightChildIndex] == 0) {
                    // 오른쪽 자식이 0일 경우
                    answer[rightChildIndex] = answer[currentIndex] - answer[leftChildIndex];
                }
                if (answer[leftChildIndex] != 0 && answer[rightChildIndex] != 0) {
                    // 자식 둘 다 0이 아닌 경우
                }
            }
            System.out.println();
        }

        System.out.println();

        /////////////////////////////////////////////

        for (int row = 0; row < blocks.length; row++) {
            int fibo = fibonacciIndex(1, row);

            System.out.printf("[%d, %d]\t", row, fibo);
            for (int index = 0; index <= row; index++) {
                System.out.printf("%d\t", answer[index + fibo]);
            }
            System.out.println();
        }

        System.out.println();

        return answer;
    }

    public int fibonacciIndex(int start, int length) {
        int index = 0;
        for (int i = start; i <= length; i++) {
            index += i;
        }
        return index;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        // TC 1
        System.out.println("\n[TC 1]");
        int[][] blocks1 = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};

        print(blocks1);

        solution2.solution(blocks1);

    }

    public static void print(int[][] arrays) {
        for (int[] array : arrays) {
            for (int i : array) {
                System.out.printf("%5d\t", i);
            }
            System.out.println();
        }
    }
}



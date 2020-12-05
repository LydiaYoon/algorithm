package street;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int solution(int[] A) {
        System.out.printf("[ ");
        for (int i : A) {
            System.out.printf("%d ", i);
        }
        System.out.println("]");


        int length = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=length; i++) {
            map.put(i, 0);
        }

        for (int i=0; i<A.length; i++) {
//            System.out.println(A[i]);
            map.put(A[i], map.get(A[i]) + 1);
        }
        System.out.println(map.toString());

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                continue;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        int[] input = new int[]{1, 2, 1};
        int result = solution3.solution(input);
        System.out.println("result : " + result + "\n\n"); // 2

        input = new int[]{2, 1, 4, 4};
        result = solution3.solution(input);
        System.out.println("result : " + result + "\n\n"); // 1

        input = new int[]{6, 2, 3, 5, 6, 3};
        result = solution3.solution(input);
        System.out.println("result : " + result + "\n\n"); // 4
    }
}
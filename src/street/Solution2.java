package street;

public class Solution2 {

    public int[] solution(String[] S) {
        System.out.print("[ ");
        for (String str : S) {
            System.out.printf("%s ", str);
        }
        System.out.println("]");

        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S.length; j++) {
                if (i < j) {
                    int length = S[i].length();
                    for (int k = 0; k < length; k++) {
                        if (S[i].charAt(k) == S[j].charAt(k)) {
                            return new int[]{i, j, k};
                        }
                    }
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        String[] input = {"abc", "bca", "dbe"};
        int[] result = solution2.solution(input);
        System.out.print("result : [ ");
        for (int i : result) {
            System.out.printf("%d ", i);
        }
        System.out.println("]\n\n");

        input = new String[]{"zzzz", "ferz", "zdsr", "fgtd"};
        result = solution2.solution(input);
        System.out.print("result : [ ");
        for (int i : result) {
            System.out.printf("%d ", i);
        }
        System.out.println("]\n\n");

        input = new String[]{"gr", "sd", "rg"};
        result = solution2.solution(input);
        System.out.print("result : [ ");
        for (int i : result) {
            System.out.printf("%d ", i);
        }
        System.out.println("]\n\n");

        input = new String[]{"bdafg", "ceagi"};
        result = solution2.solution(input);
        System.out.print("result : [ ");
        for (int i : result) {
            System.out.printf("%d ", i);
        }
        System.out.println("]\n\n");
    }
}
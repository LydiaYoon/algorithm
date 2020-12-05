package street;

public class Solution1 {

    public int solution(String S) {
        String str = S.toLowerCase();

        if (str.isEmpty()) {
            return 0;
        }

        if (str.indexOf('a') < 0) {
            return (str.length() + 1) * 2;
        }

        int result = 0;
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == 'a') {
                count++;
                if (count >= 3) {
                    return -1;
                }
            } else {
                result += 2 - count;
                count = 0;
            }
        }
        result += 2 - count;
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int res = solution1.solution("aabab");
        System.out.println("res : " + res);
        System.out.println();

        res = solution1.solution("aaba");
        System.out.println("res : " + res);
        System.out.println();

        res = solution1.solution("dog");
        System.out.println("res : " + res);
        System.out.println();

        res = solution1.solution("baaaa");
        System.out.println("res : " + res);
        System.out.println();

        res = solution1.solution("aaa");
        System.out.println("res : " + res);
        System.out.println();

        res = solution1.solution("aa");
        System.out.println("res : " + res);
        System.out.println();
    }
}
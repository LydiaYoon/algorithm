package programmers.Hash;

import java.util.Arrays;

public class Solution2 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        // EX 1 (false)
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        boolean answer = s.solution(phone_book);
        System.out.println("phone book: " + Arrays.toString(phone_book));
        System.out.println("answer: " + answer + "\n\n");

        // EX 2 (true)
        phone_book = new String[]{"123", "456", "789"};
        answer = s.solution(phone_book);
        System.out.println("phone book: " + Arrays.toString(phone_book));
        System.out.println("answer: " + answer + "\n\n");

        // EX 3 (false)
        phone_book = new String[]{"12", "123", "1235", "567", "88"};
        answer = s.solution(phone_book);
        System.out.println("phone book: " + Arrays.toString(phone_book));
        System.out.println("answer: " + answer + "\n\n");
    }
}

package programmers.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 완주하지 못한 선수
public class Solution1 {

    public String solution1(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String player : participant) hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        for (String player : completion) hashMap.put(player, hashMap.get(player) - 1);

        for (Map.Entry<String, Integer> hm : hashMap.entrySet()) {
            if (hm.getValue() != 0) {
                answer = hm.getKey();
            }
        }
        return answer;
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Long> participantMap = Arrays.asList(participant).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String name : completion) {
            long value = participantMap.get(name) - 1L;

            if (value == 0L) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, value);
            }
        }
        return participantMap.keySet().iterator().next();
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        // EX 1
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        String answer = s.solution(participant, completion);
        System.out.println("participant: " + Arrays.toString(participant));
        System.out.println("completion: " + Arrays.toString(completion));
        System.out.println("answer: " + answer + "\n\n");

        // EX 2
        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        answer = s.solution(participant, completion);
        System.out.println("participant: " + Arrays.toString(participant));
        System.out.println("completion: " + Arrays.toString(completion));
        System.out.println("answer: " + answer + "\n\n");

        // EX 3
        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        answer = s.solution(participant, completion);
        System.out.println("participant: " + Arrays.toString(participant));
        System.out.println("completion: " + Arrays.toString(completion));
        System.out.println("answer: " + answer + "\n\n");
    }
}
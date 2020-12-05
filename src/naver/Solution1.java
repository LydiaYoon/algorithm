package naver;

/*
[문제 설명]
어떤 조직의 직원들은 서로 문자열 메시지를 주고받을 때, 조직 내부에서 공유하는 키 문자열을 사용해 암호화를 거친 후 메시지를 보냅니다. 암호화 방법은 키 문자열을 구성하는 각 문자들을 그 순서를 유지하면서, 보내고자 하는 메시지 사이에 랜덤 하게 끼워 넣는 것입니다.
예를 들어, 보내고자 하는 메시지가 kkxyyz이고, 암호화에 사용할 키 문자열이 abc 라면, a, b, c를 메시지의 중간에 임의로 끼워 넣어 kkaxbycyz와 같이 바꿀 수 있습니다.

암호화된 메시지를 받은 사람은 이를 복호화하여 kkxyyz라는 원본 문자열을 얻고자 합니다. 이를 위해 아래와 같은 단순한 복호화 알고리즘을 고안하였습니다.

1. 키 문자열을 구성하는 각 문자를 암호화된 메시지에서 순서대로 찾아내어 제거하고 나머지를 원래 메시지로 간주합니다. 위 예시와 같이 암호화된 메시지가 kkaxbycyz이고 키 문자열이 abc일 경우, 메시지에서 각 키 문자를 제거한 kkxyyz를 원래 메시지로 간주합니다.
2. 여기에서는 키 문자열의 각 문자가 가장 빠른 시점에 매칭 되는 경우를 선택합니다. 예를 들어 암호화된 메시지가 aabcb이고 키 문자열이 ab일 경우, aabcb의 첫 번째 문자인 'a'와 세 번째 문자인 'b'가 제거됩니다. 따라서 acb를 원래 메시지로 간주합니다.

암호화된 메시지 m과 키 문자열 k가 매개변수로 주어집니다. 위 알고리즘을 사용하여 복호화한 문자열을 return 하도록 solution 함수를 완성해주세요.

[제한 사항]
- m은 길이가 2 이상 10,000,000 이하인 문자열입니다.
- k는 길이가 2 이상 10,000 이하인 문자열입니다.
- k의 길이는 m의 길이보다 항상 작습니다.
- m과 k는 알파벳 소문자로만 구성되어 있습니다.

[입출력 예]
m	k	result
"kkaxbycyz"	"abc"	"kkxyyz"
"acbbcdc"	"abc"	"cbdc"

[입출력 예 설명]
입출력 예 #1
k를 구성하는 모든 문자는 m에서 한 번씩 등장하기 때문에, 이를 제외하면 kkxyyz가 남게 됩니다. 따라서 kkxyyz를 return 합니다.

입출력 예 #2
메시지 m과 k에서 매칭 되는 문자를 빠른 순서대로 대문자로 표현하면, AcBbCdc입니다. 매칭 된 문자를 제외하면 cbdc가 남게 되고, 이를 return 합니다.
 */

public class Solution1 {

    public String solution(String m, String k) {

        if (m.isEmpty()) {
            throw new IllegalArgumentException("암호화된 메시지가 비어있습니다.");
        }

        if (k.isEmpty()) {
            throw new IllegalArgumentException("키가 비어있습니다.");
        }

        if (m.length() < 2 || m.length() > 10000000) {
            throw new IllegalArgumentException("m은 길이가 2 이상 10,000,000 이하인 문자열이어야 합니다.");
        }

        if (k.length() < 2 || k.length() > 10000) {
            throw new IllegalArgumentException("k는 길이가 2 이상 10,000 이하인 문자열이어야 합니다.");
        }

        if (m.length() < k.length()) {
            throw new IllegalArgumentException("k의 길이는 m의 길이보다 항상 작아야 합니다.");
        }

        String message = m.toLowerCase();
        String key = k.toLowerCase();

        StringBuilder answer = new StringBuilder();

        for (char c : key.toCharArray()) {
            int i = message.indexOf(c);
            if (i > -1) {
                answer.append(message.substring(0, i));
                message = message.substring(i + 1);
            }
        }
        answer.append(message);
        return answer.toString();
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        // TC 1
        String m1 = "kkaxbycyz";
        String k1 = "abc";
        String res1 = solution1.solution(m1, k1);
        System.out.printf("\n[TC 1]\n" +
                        "m: %s\n" +
                        "k: %s\n" +
                        "res: %s\n",
                m1, k1, res1);

        // TC 2
        String m2 = "acbbcdc";
        String k2 = "abc";
        String res2 = solution1.solution(m2, k2);
        System.out.printf("\n[TC 2]\n" +
                        "m: %s\n" +
                        "k: %s\n" +
                        "res: %s\n",
                m2, k2, res2);

        // TC 3
        String m3 = "abc";
        String k3 = "";
        String res3 = solution1.solution(m3, k3);
        System.out.printf("\n[TC 3]\n" +
                        "m: %s\n" +
                        "k: %s\n" +
                        "res: %s\n",
                m3, k3, res3);

    }
}



package leet.String;

public class Solution1 {
	
	public void reverseString(char[] s) {
		
		if (s == null || s.length < 2) return;
		
		for (int i=0; i<s.length/2; i++) {
			char temp = s[i];
			s[i] = s[s.length-1-i];
			s[s.length-1-i] = temp;
		}
		
		System.out.println(s);
	}

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		
		 
		solution.reverseString(new char[] {'h', 'e', 'l', 'l', 'o'});
		
	}

}

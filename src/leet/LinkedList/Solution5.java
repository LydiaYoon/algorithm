package leet.LinkedList;

public class Solution5 {

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		if (head.next == null)
			return true;

		while (head != null) {
			ListNode newHead = head;
			int front = newHead.val;
			while (newHead.next != null && newHead.next.next != null) {
				newHead = newHead.next;
			}
			if (newHead.next != null) {
				int back = newHead.next.val;
				System.out.println(front + ", " + back);
				newHead.next = null;
				head = head.next;

				if (front == back) {
					continue;
				} else {
					return false;
				}
			} else {
				break;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution5 solution = new Solution5();

		// Input: [ 1, 2 ]
		// Output: false
//		ListNode[] input = new ListNode[2];
//		input[0] = new ListNode(2, null);
//		input[1] = new ListNode(1, input[0]);

		// Input: [ 1, 2, 2, 1 ]
		// Output: true
//		ListNode[] input = new ListNode[4];
//		input[0] = new ListNode(1, null);
//		input[1] = new ListNode(2, input[0]);
//		input[2] = new ListNode(2, input[1]);
//		input[3] = new ListNode(1, input[2]);

		// Input: []
		// Output: true

		// Input: [ 1 ]
		// Output: true;
//		ListNode[] input = new ListNode[1];
//		input[0] = new ListNode(1, null);

		// Input: [ 0, 0 ]
		// output: true;
//		ListNode[] input = new ListNode[2];
//		input[0] = new ListNode(0, null);
//		input[1] = new ListNode(0, input[0]);

		// Input: [ 1, 2, 2, 1 ]
		// Output: true
		ListNode[] input = new ListNode[3];
		input[0] = new ListNode(1, null);
		input[1] = new ListNode(0, input[0]);
		input[2] = new ListNode(1, input[1]);

		ListNode head = input[input.length - 1];
		printNode(head);
		System.out.println("RES: " + solution.isPalindrome(head));

	}

	public static void printNode(ListNode head) {
		System.out.print("[ ");
		while (head != null) {
			if (head.next != null) {
				System.out.print(head + " ¡æ ");
			} else {
				System.out.print(head);
			}
			head = head.next;
		}
		System.out.print(" ] \n");
	}
}

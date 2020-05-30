package leet.LinkedList;

import leet.ListNode;
import leet.NodeUtils;

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
				// System.out.println(front + ", " + back);
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
		ListNode head = new ListNode();

		// TestCase 1
		// Input: [ 1, 2 ]
		// Output: false
		ListNode[] case1 = new ListNode[2];
		NodeUtils.initListNode(case1, 1);
		NodeUtils.connectListNode(case1);
		head = case1[0];

		NodeUtils.printListNode(head);
		System.out.println("RES: " + solution.isPalindrome(head) + "\n\n");

		// TestCase 2
		// Input: [ 1, 2, 2, 1 ]
		// Output: true
		ListNode[] case2 = new ListNode[4];
		case2[0] = new ListNode(1);
		case2[1] = new ListNode(2);
		case2[2] = new ListNode(2);
		case2[3] = new ListNode(1);
		NodeUtils.connectListNode(case2);
		head = case2[0];

		NodeUtils.printListNode(head);
		System.out.println("RES: " + solution.isPalindrome(head) + "\n\n");

		// TestCase 3
		// Input: []
		// Output: true
		ListNode case3 = null;
		head = case3;

		NodeUtils.printListNode(head);
		System.out.println("RES: " + solution.isPalindrome(head) + "\n\n");

		// TestCase 4
		// Input: [ 1 ]
		// Output: true;
		ListNode case4 = new ListNode(1);
		head = case4;

		NodeUtils.printListNode(head);
		System.out.println("RES: " + solution.isPalindrome(head) + "\n\n");

		// TestCase 5
		// Input: [ 0, 0 ]
		// output: true;
		ListNode[] case5 = new ListNode[2];
		case5[0] = new ListNode(0);
		case5[1] = new ListNode(0);
		NodeUtils.connectListNode(case5);
		head = case5[0];

		NodeUtils.printListNode(head);
		System.out.println("RES: " + solution.isPalindrome(head) + "\n\n");

		// TestCase 6
		// Input: [ 1, 2, 2, 1 ]
		// Output: true
		ListNode[] case6 = new ListNode[4];
		case6[0] = new ListNode(1);
		case6[1] = new ListNode(2);
		case6[2] = new ListNode(2);
		case6[3] = new ListNode(1);
		NodeUtils.connectListNode(case6);
		head = case6[0];

		NodeUtils.printListNode(head);
		System.out.println("RES: " + solution.isPalindrome(head));

	}

}

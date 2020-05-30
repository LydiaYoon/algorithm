package leet.LinkedList;

import leet.ListNode;
import leet.NodeUtils;

public class Solution2 {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (n < 1) {
			return head;
		}

		int length = 0;
		ListNode listNode = head;

		// 전체 탐색하여 길이를 구한다.
		while (listNode != null) {
			listNode = listNode.next;
			length++;
		}

		if (length < n) {
			return head;
		} else if (length == n) {
			return head.next;
		}

		// 삭제할 위치 이전의 node로 찾아간다.
		int index = length - n;
		listNode = head;
		while (index > 1) {
			listNode = listNode.next;
			index--;
		}

		// node를 삭제한다.
		if (listNode.next.next != null) {
			listNode.next = listNode.next.next;
		} else {
			listNode.next = null;
		}

		return head;
	}
	
	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		// example 1
		ListNode[] case1 = new ListNode[5];
		NodeUtils.initListNode(case1, 1);
		NodeUtils.connectListNode(case1);
		ListNode head = case1[0];
		
		System.out.println("before : ");
		NodeUtils.printListNode(head);
		head = solution.removeNthFromEnd(head, 2); // [1, 2, 3, 5]
		System.out.println("after : ");
		NodeUtils.printListNode(head);

		System.out.println();
		
		// example 2
		ListNode case2 = new ListNode(1, null);

		System.out.println("before : ");
		NodeUtils.printListNode(case2);
		case2 = solution.removeNthFromEnd(case2, 1); // []
		System.out.println("after : ");
		NodeUtils.printListNode(case2);
		
	}
}

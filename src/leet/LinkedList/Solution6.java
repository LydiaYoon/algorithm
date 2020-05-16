package leet.LinkedList;

import java.util.ArrayList;

public class Solution6 {

	public boolean hasCycle(ListNode head) {

		ArrayList<ListNode> nodes = new ArrayList<>();
		ListNode listNode = head;

		while (listNode != null) {
			if (nodes.contains(listNode)) {
				return true;
			} else {
				nodes.add(listNode);
				listNode = listNode.next;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution6 solution = new Solution6();
		ListNode head = new ListNode();

		// TestCase 1
		ListNode[] case1 = new ListNode[4];
		case1[0] = new ListNode(3);
		case1[1] = new ListNode(2);
		case1[2] = new ListNode(0);
		case1[3] = new ListNode(-4);
		NodeUtils.connectNode(case1);
		case1[3].next = case1[1];
		head = case1[0];

		NodeUtils.printNodeArray(case1);
		System.out.println("RES: " + solution.hasCycle(head) + "\n\n");

		// TestCase 2
		ListNode[] case2 = new ListNode[2];
		case2[0] = new ListNode(1);
		case2[1] = new ListNode(2);
		NodeUtils.connectNode(case2);
		case2[1].next = case2[0];
		head = case2[0];

		NodeUtils.printNodeArray(case2);
		System.out.println("RES: " + solution.hasCycle(head) + "\n\n");

		// TestCase 3
		ListNode case3 = new ListNode(1);
		head = case3;

		NodeUtils.printNode(case3);
		System.out.println("RES: " + solution.hasCycle(head) + "\n\n");

	}

}

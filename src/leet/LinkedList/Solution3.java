package leet.LinkedList;

import java.util.ArrayList;

public class Solution3 {

	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		int length = 0;
		ListNode listNode = head;

		while (listNode != null) {
			listNode = listNode.next;
			length++;
		}

		System.out.println("length: " + length);
		System.out.println("listNode: " + listNode);
				
		ListNode[] nodes = new ListNode[length];
		listNode = head;
		for (int i = 0; i < length; i++) {
			nodes[i] = new ListNode(listNode.val, null);
			listNode = listNode.next;
		}
		
		for (int i=length-1; i>0; i--) {
			nodes[i].next = nodes[i-1];
		}
		
		return nodes[nodes.length-1];
	}
		   
	   public ListNode reverseList2(ListNode head) {
		    /* iterative solution */
		    ListNode newHead = null;
		    while (head != null) {
		        ListNode next = head.next;
		        head.next = newHead;
		        newHead = head;
		        head = next;
		    }
		    return newHead;
		}
	   
	   public ListNode reverseList3(ListNode head) {
		    /* recursive solution */
		    return reverseListInt(head, null);
		}

		private ListNode reverseListInt(ListNode head, ListNode newHead) {
		    if (head == null)
		        return newHead;
		    ListNode next = head.next;
		    head.next = newHead;
		    return reverseListInt(next, head);
		}


	   
	public static void main(String[] args) {
		Solution3 solution = new Solution3();

		ListNode[] nodes = new ListNode[5];
		nodes[0] = new ListNode(5, null);
		nodes[1] = new ListNode(4, nodes[0]);
		nodes[2] = new ListNode(3, nodes[1]);
		nodes[3] = new ListNode(2, nodes[2]);
		nodes[4] = new ListNode(1, nodes[3]);
		ListNode head = nodes[nodes.length - 1];

		System.out.println("before : ");
		System.out.println("[ " + head + " ]");
		System.out.println();

		head = solution.reverseList3(head); // [5, 4, 3, 2, 1]

		System.out.println();
		System.out.println("after : ");
		System.out.println("[ " + head + " ] \n");
	}

}

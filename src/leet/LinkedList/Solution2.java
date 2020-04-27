package leet.LinkedList;

public class Solution2 {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (n < 1) {
			return head;
		}

		int length = 0;
		ListNode listNode = head;

		while (listNode != null) {
			listNode = listNode.next;
			length++;
		}

		if (length < n) {
			return head;
		} else if (length == n) {
			return head.next;
		}

		int index = length - n;
		listNode = head;
		while (index > 1) {
			listNode = listNode.next;
			index--;
		}

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
		ListNode[] nodes = new ListNode[5];
		nodes[0] = new ListNode(5, null);
		nodes[1] = new ListNode(4, nodes[0]);
		nodes[2] = new ListNode(3, nodes[1]);
		nodes[3] = new ListNode(2, nodes[2]);
		nodes[4] = new ListNode(1, nodes[3]);
		ListNode head = nodes[nodes.length - 1];

		System.out.println("before : ");
		printNode(head);

		head = solution.removeNthFromEnd(head, 2); // [1, 2, 3, 5]

		System.out.println("after : ");
		printNode(head);

		// example 2
		ListNode node = new ListNode(1, null);

		System.out.println("before : ");
		printNode(node);

		node = solution.removeNthFromEnd(node, 1); // []

		System.out.println("after : ");
		printNode(node);
		

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

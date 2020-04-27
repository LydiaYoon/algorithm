package leet.LinkedList;

public class Solution4 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 != null)
			return l2;
		else if (l1 != null && l2 == null)
			return l1;
		else if (l1 == null && l2 == null)
			return null;

		ListNode newHead = new ListNode(0, null);
		ListNode head = newHead;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;

		}

		if (l1 != null) {
			head.next = l1;
		}

		if (l2 != null) {
			head.next = l2;
		}

		return newHead.next;
	}
	
	public static void main(String[] args) {
		Solution4 solution = new Solution4();

		// Input: [ 1, 2, 4 ], [ 1, 3, 4 ]
		// Output: [ 1, 1, 2, 3, 4, 4 ]
		/*
		 * ListNode[][] input = new ListNode[2][3]; input[0][0] = new ListNode(4, null);
		 * input[0][1] = new ListNode(2, input[0][0]); input[0][2] = new ListNode(1,
		 * input[0][1]); input[1][0] = new ListNode(4, null); input[1][1] = new
		 * ListNode(3, input[1][0]); input[1][2] = new ListNode(1, input[1][1]);
		 * ListNode[] heads = new ListNode[2]; heads[0] = input[0][input[0].length - 1];
		 * heads[1] = input[1][input[1].length - 1];
		 */

		// Input: [ ], [ 0 ]
		// Output: [ 0 ]
		/*
		 * ListNode[] input = new ListNode[2]; input[0] = null; input[1] = new
		 * ListNode(0, null); ListNode[] heads = new ListNode[2]; heads[0] = input[0];
		 * heads[1] = input[1];
		 */

		// Input: [ 2 ], [ 1 ]
		// Output: [ 1, 2 ]

		ListNode[] input = new ListNode[2];
		input[0] = new ListNode(2, null);
		input[1] = new ListNode(1, null);
		ListNode[] heads = new ListNode[2];
		heads[0] = input[0];
		heads[1] = input[1];

		System.out.println("input : ");
		printNode(heads[0]);
		printNode(heads[1]);

		ListNode output = solution.mergeTwoLists(heads[0], heads[1]);
		System.out.println("output : ");
		printNode(output);

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

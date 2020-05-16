package leet.LinkedList;

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
		NodeUtils.initNode(nodes, 1);
		NodeUtils.connectNode(nodes);
		ListNode head = nodes[0];

		System.out.println("before : ");
		NodeUtils.printNode(head);
		System.out.println();

		head = solution.reverseList3(head); // [5, 4, 3, 2, 1]

		System.out.println();
		System.out.println("after : ");
		NodeUtils.printNode(head);
	}
	
}

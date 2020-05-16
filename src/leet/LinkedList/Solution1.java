package leet.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution1 {

    public void deleteNode(ListNode node) {    	
    	node.val = node.next.val;
    	node.next = node.next.next;    	        
    }
	
	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		
		ListNode[] nodes = new ListNode[4];
		
		// TestCase 1
		nodes[0] = new ListNode(4);
		nodes[1] = new ListNode(5);
		nodes[2] = new ListNode(1);
		nodes[3] = new ListNode(9);
		NodeUtils.connectNode(nodes);
		ListNode head = nodes[0];
		
		System.out.println("before : ");
		NodeUtils.printNode(head);
		
		solution.deleteNode(nodes[2]);
//		solution.deleteNode(nodes[1]);
		
		System.out.println("after : ");
		NodeUtils.printNode(head);
	}
}

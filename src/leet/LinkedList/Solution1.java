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
		nodes[0] = new ListNode(9, null);
		nodes[1] = new ListNode(1, nodes[0]);
		nodes[2] = new ListNode(5, nodes[1]);
		nodes[3] = new ListNode(4, nodes[2]);
		ListNode head = nodes[nodes.length-1];
		
		System.out.println("before : ");
		printNode(head);
		
//		solution.deleteNode(nodes[2]);
		solution.deleteNode(nodes[1]);
		
		System.out.println("after : ");
		printNode(head);
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

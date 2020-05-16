package leet.LinkedList;

public class NodeUtils {

	// ListNode 배열 안의 node들을 n부터 시작하는 값으로 초기화
	public static void initNode(ListNode[] nodes, int n) {
		if (nodes != null) {
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new ListNode(n + i);
			}
		}
	}

	// 다음 node가 null 일 때 까지 모두 출력
	public static void printNode(ListNode head) {
		System.out.print("[ ");
		while (head != null) {
			if (head.next != null) {
				System.out.print(head + " → ");
			} else {
				System.out.print(head);
			}
			head = head.next;
		}
		System.out.print(" ] \n");
	}

	// ListNode 배열 안의 node들을 순서대로 전부 연결
	public static void connectNode (ListNode[] nodes) {
		for (int i=0; i<nodes.length-1; i++) {
			nodes[i].next = nodes[i+1];
		}
	}

	// ListNode 배열 안의 node들의 값을 순서대로 출력
	public static void printNodeArray(ListNode[] nodes) {
		System.out.print("[ ");
		for (int i = 0; i < nodes.length; i++) {
			System.out.print(nodes[i].val);
			if (i < nodes.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(" ] \n");
	}
}

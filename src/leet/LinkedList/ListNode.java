package leet.LinkedList;

public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return Integer.toString(val);
	}

	public void print() {
		System.out.print("[ ");

		ListNode head = this;
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
}

package leet.LinkedList;

public class ListNode {
	int val;
	ListNode next;

	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		if (next != null) {
			return val + " ¡æ " + next;
		} else {
			return Integer.toString(val);
		}
	}
}

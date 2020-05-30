package leet;

public class NodeUtils {

	// ListNode 배열 안의 node들을 n부터 시작하는 값으로 초기화
	public static void initListNode(ListNode[] nodes, int n) {
		if (nodes != null) {
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new ListNode(n + i);
			}
		}
	}

	// TreeNode 배열 안의 node들을 n부터 시작하는 값으로 초기화
	public static void initTreeNode(TreeNode[] nodes, int n) {
		if (nodes != null) {
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new TreeNode(n + i);
			}
		}
	}

	// 연결된 ListNode들을 모두 출력
	public static void printListNode(ListNode head) {
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

	// 연결된 TreeNode들을 모두 출력
	public static void printTreeNode(TreeNode[] nodes) {
		for (int i = 0; i <= (int) Math.sqrt(nodes.length); i++) {
			System.out.printf("   %3d   \n", nodes[i].val);

			if (nodes[i].left != null && nodes[i].right != null) {
				System.out.printf("%3d   %3d\n", nodes[i].left.val, nodes[i].right.val);
			} else if (nodes[i].left != null && nodes[i].right == null) {
				System.out.printf("%3d    X \n", nodes[i].left.val);
			} else if (nodes[i].left == null && nodes[i].right != null) {
				System.out.printf("%3d    X \n", nodes[i].right.val);
			} else {
				System.out.printf(" X     X \n");
			}
			System.out.println();
		}
	}

	// ListNode 배열 안의 node들을 순서대로 전부 연결
	public static void connectListNode(ListNode[] nodes) {
		for (int i = 0; i < nodes.length - 1; i++) {
			nodes[i].next = nodes[i + 1];
		}
	}

	// TreeNode 배열 안의 node들을 순서대로 전부 연결
	public static void connectTreeNode(TreeNode[] nodes) {
		for (int i = 0; i <= (int) Math.sqrt(nodes.length); i++) {
			if (nodes[i] != null) {
				int left = ((i + 1) * 2) - 1;
				int right = (i + 1) * 2;

				if (nodes[left] != null) {
					nodes[i].left = nodes[left];
				}
				if (nodes[right] != null) {
					nodes[i].right = nodes[right];
				}
			}
		}
	}

	// Node 배열 안의 node들의 값을 순서대로 출력
	public static void printNodeArray(Node[] nodes) {
		System.out.print("[ ");
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				System.out.print(nodes[i].toString());
			} else {
				System.out.print("null");
			}
			if (i < nodes.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(" ] \n");
	}
}

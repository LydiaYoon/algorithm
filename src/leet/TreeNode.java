package leet;

public class TreeNode implements Node {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return Integer.toString(val);
	}

	public void print() {
		if (this != null) {
			System.out.printf("   %3d\n", this.val);

			if (this.left != null) {
				System.out.printf("%3d", this.left.val);
			} else {
				System.out.printf(" X ");
			}
			System.out.printf("   ");
			if (this.right != null) {
				System.out.printf("%3d", this.right.val);
			} else {
				System.out.printf(" X ");
			}
			System.out.printf("\n\n");
		}
	}

	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
}
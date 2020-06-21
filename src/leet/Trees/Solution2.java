package leet.Trees;

import leet.NodeUtils;
import leet.TreeNode;

public class Solution2 {

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}

		if (root.left != null && root.val < root.left.val) {
			return false;
		}

		if (root.right != null && root.val > root.right.val) {
			return false;
		}

		return isValidBST(root.left) && isValidBST(root.right);
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		// TestCase 1
		// Input: [ 2, 1, 3 ]
		// Output: true
		TreeNode[] case1 = new TreeNode[3];
		case1[0] = new TreeNode(2);
		case1[1] = new TreeNode(1);
		case1[2] = new TreeNode(3);
//		NodeUtils.connectTreeNode(case1);
//		NodeUtils.printNodeArray(case1);
//		NodeUtils.printTreeNode(case1);
		
		System.out.println("\n"+"========================================" + "\n");

		// TestCase 2
		// Input: [ 5, 1, 4, null, null, 3, 6 ]
		// Output: false
		TreeNode[] case2 = new TreeNode[7];
		case2[0] = new TreeNode(5);
		case2[1] = new TreeNode(1);
		case2[2] = new TreeNode(4);
		case2[3] = null;
		case2[4] = null;
		case2[5] = new TreeNode(3);
		case2[6] = new TreeNode(6);
//		NodeUtils.connectTreeNode(case2);
//		NodeUtils.printNodeArray(case2);
//		NodeUtils.printTreeNode(case2);
		
		System.out.println("\n"+"========================================" + "\n");
		
		TreeNode[] case3 = new TreeNode[15];
		NodeUtils.connectTreeNode(case3);
	}

}

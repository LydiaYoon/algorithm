package leet.Trees;

import leet.NodeUtils;
import leet.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class Solution1 {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		Solution1 solution = new Solution1();

		// TestCase 1
		// Input: [ 3, 9, 20, null, null, 15, 7 ]
		// Output: 3
		TreeNode[] case1 = new TreeNode[7];
		case1[0] = new TreeNode(3);
		case1[1] = new TreeNode(9);
		case1[2] = new TreeNode(20);
		case1[3] = null;
		case1[4] = null;
		case1[5] = new TreeNode(15);
		case1[6] = new TreeNode(7);

		NodeUtils.connectTreeNode(case1);
		NodeUtils.printNodeArray(case1);

		System.out.println("output: " + solution.maxDepth(case1[0]));
	}

}

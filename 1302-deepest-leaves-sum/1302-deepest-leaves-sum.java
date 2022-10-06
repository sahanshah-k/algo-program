/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int depth = findDepth(root, 0);
        return findDepthSum(root, depth);
    }
    
    private int findDepthSum(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (depth == 0) {
            return root.val;
        }
        return findDepthSum(root.left, depth - 1) + findDepthSum(root.right, depth - 1);
    }
    
    private int findDepth(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return depth;
        }
        return Math.max(findDepth(root.left, depth + 1), findDepth(root.right, depth + 1));
    }
}
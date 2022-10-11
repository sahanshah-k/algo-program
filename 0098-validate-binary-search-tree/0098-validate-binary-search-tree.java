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
    public boolean isValidBST(TreeNode root) {
        long lastMax = Long.MAX_VALUE, lastMin = Long.MIN_VALUE;
        return helper(root, lastMax, lastMin);
    }
    
    boolean helper(TreeNode root, long lastMax, long lastMin) {
        if (root == null) {
            return true;
        }
        if (root.val >= lastMax || root.val <= lastMin) {
            return false;
        }
        return helper(root.left, root.val, lastMin) && helper(root.right, lastMax, root.val);
    }
}
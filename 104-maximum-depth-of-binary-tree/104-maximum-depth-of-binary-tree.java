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
    public int maxDepth(TreeNode root) {
        return helper(root, 0, 0);
    }
    
    int helper(TreeNode node, int count, int maxCount) {        
        if (node == null) {
            maxCount = Math.max(maxCount, count);
            return maxCount;
        }
        
        return Math.max(helper(node.left, count + 1, maxCount), helper(node.right, count + 1, maxCount));
    }
}
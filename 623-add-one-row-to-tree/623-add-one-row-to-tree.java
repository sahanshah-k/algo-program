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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode node = root;
        if (depth == 1) {
            TreeNode newNodeLeft = new TreeNode(val, root, null);
            return newNodeLeft;
        }
        helper(node, val, depth);
        return root;
    }
    
    void helper(TreeNode node, int val, int depth) {
        if (node == null) {
            return;
        }
        
        if (depth - 2 == 0) {
            TreeNode newNodeLeft = new TreeNode(val, node.left, null);
            TreeNode newNodeRight = new TreeNode(val, null, node.right);
            node.left = newNodeLeft;
            node.right = newNodeRight;
            return;
        }
        
        helper(node.left, val, depth - 1);
        helper(node.right, val, depth - 1);
    }
}
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot);
    }
    
    boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        if (isIdentical(root, subRoot)) {
            return true;
        }
        
        return helper(root.left, subRoot) || helper(root.right, subRoot);
    }
    
    boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }
        
        return root.val == subRoot.val 
            && isIdentical(root.left, subRoot.left) 
            && isIdentical(root.right, subRoot.right);
    }
}
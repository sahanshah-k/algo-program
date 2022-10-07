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
    public int maxPathSum(TreeNode root) {
        int[] max = helper(root);
        return max[1];
    }
    
    int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        
        int[] leftSum = helper(root.left);
        
        int leftMaxSumAsBranch = leftSum[0];
        int leftMaxPathSum = leftSum[1];
        
        int[] rightSum = helper(root.right);
    
        int rightMaxSumAsBranch = rightSum[0];
        int rightMaxPathSum = rightSum[1];
        
        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        
        int value = root.val;
        
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxTriangleSum = Math.max(maxSumAsBranch, leftMaxSumAsBranch + value + rightMaxSumAsBranch);
        int maxPathSum = Math.max(rightMaxPathSum, Math.max(leftMaxPathSum, maxTriangleSum));
        return new int[] {maxSumAsBranch, maxPathSum};
    }
}
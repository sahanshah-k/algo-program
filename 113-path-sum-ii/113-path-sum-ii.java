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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }
        return traverse(root, targetSum, out, new ArrayList<Integer>());
    }
    
    
    List<List<Integer>> traverse(TreeNode node, int targetSum, List<List<Integer>> out, List<Integer> curr) {
        
        if (node.left == null && node.right == null) {
            curr.add(node.val);
            int sum = 0;
            for (int number : curr){
                sum += number;        
            }
            if (sum == targetSum) {
                out.add(new ArrayList<Integer>(curr));
            }
            curr.remove(curr.size() - 1);
        }
        
        if (node.left != null) {
            curr.add(node.val);
            traverse(node.left, targetSum, out, curr);        
        }
        
        if (node.right != null) {
            curr.add(node.val);
            traverse(node.right, targetSum, out, curr);
        }
        if (curr.size() > 0) {
            curr.remove(curr.size() - 1);
        }
        return out;
    
    }
}
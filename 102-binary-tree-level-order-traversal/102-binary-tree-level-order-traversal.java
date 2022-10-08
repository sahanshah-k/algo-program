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

//DFS use queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) {
            return out;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < len; i ++) {
                TreeNode tree = q.remove();
                sub.add(tree.val);
                if (tree.left != null) {
                    q.add(tree.left);
                }
                if (tree.right != null) {
                    q.add(tree.right);
                }
            }
            out.add(sub);
        }
        return out;
    }
}
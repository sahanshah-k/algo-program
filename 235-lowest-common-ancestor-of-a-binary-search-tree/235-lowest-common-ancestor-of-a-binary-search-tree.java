/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        pathHelper(root, pList, p);
        pathHelper(root, qList, q);
        int len = Math.min(pList.size(), qList.size());
        for (int i = 0; i < len; i ++) {
            if (pList.get(i).val != qList.get(i).val) {
                return pList.get(i - 1);
            }
            if (i == len - 1) {
                return pList.get(i);
            }
        }
        return null;
    }
    
    boolean pathHelper(TreeNode root, List<TreeNode> list, TreeNode tn) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (root.val == tn.val) {
            return true;
        }
        boolean leftBool = pathHelper(root.left, list, tn);
        boolean rightBool = pathHelper(root.right, list, tn);
        if (leftBool || rightBool) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
}
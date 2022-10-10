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
//     public boolean findTarget(TreeNode root, int k) {
//         HashSet<Integer> set = new HashSet<>();
//         return helper(root, set, k);
//     }
    
//     private boolean helper(TreeNode root, HashSet<Integer> set, int k) {
//         if (root == null) {
//             return false;
//         }
        
//         boolean left = helper(root.left, set, k);
//         if (set.contains(root.val)) {
//             return true;
//         }
//         set.add(k - root.val);
//         boolean right = helper(root.right, set, k);
//         return right || left;
//     }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                l ++;
            } else if (sum > k) {
                r --;
            }
        }
        return false;
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }    
}
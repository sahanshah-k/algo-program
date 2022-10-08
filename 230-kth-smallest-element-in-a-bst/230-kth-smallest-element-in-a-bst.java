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
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
//         helper(root, pq);
//         while (!pq.isEmpty() && k > 1) {
//             k --;
//             pq.poll();
//         }
//         return pq.poll();
//     }
    
//     void helper(TreeNode root, PriorityQueue<Integer> pq) {
//         if (root == null) {
//             return;
//         }
//         pq.add(root.val);
//         helper(root.left, pq);
//         helper(root.right, pq);
//     }
    
    //inorder traversal of bst will be in increasing order;
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root, arr);
        return arr.get(k - 1);
    }
    
    void helper(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        helper(root.left, arr);
        arr.add(root.val);
        helper(root.right, arr);
    }
    
}
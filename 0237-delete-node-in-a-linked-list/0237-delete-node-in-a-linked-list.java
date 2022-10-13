/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        while(node.next != null) {
            int v = node.next.val; 
            node.val = v;
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
        
    }
}
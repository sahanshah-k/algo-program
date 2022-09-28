/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.next;
        }
        dummy = head;        
        int l = stack.size() / 2;
                
        for (int i = 0; i < l; i ++) {
            ListNode temp = dummy.next;
            dummy.next = stack.pop();
            dummy = dummy.next;
            dummy.next = temp;
            dummy = dummy.next;
        }

        if (dummy != null) {
            dummy.next = null;
        }
        
    }
}
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
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if (n == 1 && head.next == null) {
    //         return null;
    //     }
    //     ListNode temp = head;
    //     int l = 0;
    //     while (temp != null) {
    //         l ++;
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     n = l - n;
    //     l = 0;
    //     if (n == 0) {
    //         return head.next;
    //     }
    //     while (temp != null) {
    //         l ++;
    //         if (l == n) {
    //             temp.next = temp.next.next;
    //             break;
    //         }
    //         temp = temp.next;
    //     }
    //     return head;
    // }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 0; i <= n; i ++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
    
}
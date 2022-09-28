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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode out = new ListNode(0);
        ListNode head = out;
        while (true) {
            if (list1 == null) {
                out.next = list2;
                break;
            }
            if (list2 == null) {
                out.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                out.next = list1;
                list1 = list1.next;
            } else {
                out.next = list2;
                list2 = list2.next;
            }
            out = out.next;
        }
       return head.next;
    }
}
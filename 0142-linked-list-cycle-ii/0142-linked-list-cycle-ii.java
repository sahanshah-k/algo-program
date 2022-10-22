/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        Map<ListNode, ListNode> map = new HashMap<>();
        
        while (head != null) {
            if (map.containsKey(head)) {
                return map.get(head);
            }
            map.put(head, head);
            head = head.next;
        }
        return null;
    }
}
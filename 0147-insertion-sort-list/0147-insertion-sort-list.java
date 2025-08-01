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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // New sorted list dummy head
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;
            ListNode next = curr.next;

            // Find the position to insert current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert current node into sorted list
            curr.next = prev.next;
            prev.next = curr;

            // Move to next node
            curr = next;
        }

        return dummy.next;
    }
}
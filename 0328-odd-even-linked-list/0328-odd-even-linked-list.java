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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // remember start of even nodes

        while (even != null && even.next != null) {
            odd.next = even.next;   // link next odd
            odd = odd.next;         // move odd pointer

            even.next = odd.next;   // link next even
            even = even.next;       // move even pointer
        }

        odd.next = evenHead; // connect odd list with even list
        return head;
    }
}
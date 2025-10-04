/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {
            // When one list ends, start from the head of the other list
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either both are null (no intersection), or at intersection node
        return a;
    }
}
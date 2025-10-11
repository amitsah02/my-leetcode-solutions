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
        // Copy data from next node into current node
        node.val = node.next.val;
        // Skip the next node
        node.next = node.next.next;

    }
}
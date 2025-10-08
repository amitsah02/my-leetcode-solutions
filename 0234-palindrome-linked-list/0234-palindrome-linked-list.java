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
      // helper fun to find mid 
     public ListNode isMid(ListNode head) {
        ListNode slow = head;
         ListNode fast = head ;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next== null){
            return true;
        }
       // step 1: find mid 
       ListNode mid = isMid(head);
       // step 2: reverse 2nd (right) half 
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;
         
         while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
         }
          ListNode left = head ;// left head node 
          ListNode right = prev;
          
          // step 3: compare left Node and Right Node
          while(right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
          } 

          return true;
    }
    

}
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
    public ListNode sortList(ListNode head) {
           if(head == null || head.next == null) return head;
          ListNode mid = findMid(head);
          ListNode right = mid.next;
          mid.next = null;
          ListNode x = sortList(head);
          ListNode y = sortList(right);
          return merge(x,y);
           
    }

    static ListNode merge(ListNode left , ListNode right){
           ListNode dummy = new ListNode(0);
           ListNode tail = dummy;
           while(left != null && right != null){
               if(left.val < right.val){
                     tail.next = left;
                     left = left.next;
               }else{
                tail.next = right;
                right = right.next;
               }
               tail = tail.next;
           }
           tail.next =  (left == null)  ? right: left;
           return dummy = dummy.next; 
    }

    static ListNode findMid(ListNode head){
        ListNode prev = null;
          ListNode slow = head;
          ListNode fast = head;
          while(fast != null && fast.next != null){
             prev = slow;
              slow = slow.next;
              fast = fast.next.next;
          }
          return prev;
    } 
}
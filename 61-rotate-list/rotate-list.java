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
    public ListNode rotateRight(ListNode head, int k) {
         if(head == null || head.next == null || k == 0) return head;
          int count = 1;
          ListNode tail = head;
          while(tail.next != null){
               count++;
               tail = tail.next;
          }
          tail.next = head;

          k = k % count;
          int splitCount = count - k;
          ListNode temp = head;
          for(int i=1;i<splitCount;i++){
                temp = temp.next;
          }
          ListNode newHead = temp.next;
          temp.next = null;
          return newHead;

    }
}
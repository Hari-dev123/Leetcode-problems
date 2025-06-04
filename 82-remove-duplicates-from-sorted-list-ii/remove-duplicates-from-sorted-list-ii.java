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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode prev = dummy;
       while(head != null && head.next != null){
            if(head.val == head.next.val){
                int dup = head.val;
                while(head != null && head.val == dup){
                    head = head.next;
                }
                prev.next = head;
            }else{
                prev = prev.next;
                head = head.next;
            }
       }
        return dummy.next;
    }
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n == 1)) return null;
        ListNode temp = head;
        int  l = 0;
        while(temp != null){
             temp = temp.next;
             l++;
        }
        int pos = l - n;
        if(pos == 0){
             head = head.next;
             return head;
        }
        temp = head;
        for(int i=1;i<pos;i++){
             temp = temp.next;
        }
         if(temp.next.next == null){
            temp.next = null;
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }
}
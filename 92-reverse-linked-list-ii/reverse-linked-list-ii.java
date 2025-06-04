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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1;i<left;i++){
             prev = prev.next;
        }
        ListNode rightNode  = prev;
        for(int i=0;i<right-left+1;i++){
           rightNode = rightNode.next;
        }
        ListNode rightAfterNode = rightNode.next;
        ListNode startNode = prev.next;
        prev.next = null;
        rightNode.next = null;
        ListNode reverseNode = rev(startNode);
        prev.next = reverseNode;
        startNode.next = rightAfterNode;
        return dummy.next;
    }
    private static ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }
        return prev;
    }
}
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
          
        int c1 = 0 , c2 = 0;
        ListNode temp1 = headA , temp2 = headB;
        while(temp1 != null){
            c1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            c2++;
            temp2 = temp2.next;
        }
        int jump = 0;
        ListNode a = headA;
        ListNode b = headB;
        if(c1 < c2){
            jump = c2  - c1;
            for(int i=1;i<=jump;i++){
                 b = b.next;
            }
        }else{
            jump = c1 - c2;
             for(int i=1;i<=jump;i++){
                 a = a.next;
            }
        }

        while(a != null && b != null){
             if(a == b) return a;
             a = a.next;
             b = b.next;
        }
        return null;
        
    }

}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode secondHalf = reverseList(slow);

        
        ListNode firstHalf = head;
        ListNode temp = secondHalf;
        
        
        while (temp != null) {
            if (firstHalf.val != temp.val) {
                return false;
                
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        
        reverseList(secondHalf);

        return true;
    }

    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

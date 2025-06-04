class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0); // Dummy head for < x
        ListNode afterHead = new ListNode(0);  // Dummy head for >= x
        ListNode before = beforeHead;
        ListNode after = afterHead;
        
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;          // Important to avoid cycle
        before.next = afterHead.next;  // Join both partitions
        return beforeHead.next;
    }
}

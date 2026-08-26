class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode curr = slow.next;
        ListNode next = null;
        ListNode prev = null;

        // Break first half from second half
        slow.next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Start reordering
        slow = head;
        fast = prev;

        while (fast != null) {

            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;

            slow.next = fast;
            fast.next = slowNext;

            slow = slowNext;
            fast = fastNext;
        }
    }
}
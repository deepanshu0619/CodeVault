class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Find middle using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the half after middle
        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;

        while (preCurrent.next != null) {

            ListNode current = preCurrent.next;

            preCurrent.next = current.next;

            current.next = preMiddle.next;

            preMiddle.next = current;
        }

        // Start reordering
        slow = head;
        fast = preMiddle.next;

        while (slow != preMiddle) {

            preMiddle.next = fast.next;

            fast.next = slow.next;

            slow.next = fast;

            slow = fast.next;

            fast = preMiddle.next;
        }
    }
}
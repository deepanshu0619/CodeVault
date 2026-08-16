/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        
        // Move until fast or fast.next is null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                ListNode temp = head;
                
                // Move temp and slow at the same pace
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return slow;  // Starting point of the cycle
            }
        }
        
        // If no cycle is found, return null
        return null;
    }
}
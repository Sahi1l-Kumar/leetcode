/**
 * Problem: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Follow up: Could you do this in one pass?
 *
 * Approach (Two Pointers - One Pass):
 * Use two pointers with a gap of n nodes between them:
 * 1. Create a dummy head node pointing to the original head.
 * 2. Initialize first pointer to dummy head and second pointer to n+1 steps ahead.
 * 3. Move both pointers forward until the second pointer reaches the end.
 * 4. When the second pointer reaches the end, the first pointer will be at the node before the one to be removed.
 * 5. Remove the node by updating the first pointer's next to skip the target node.
 * 
 * Time Complexity: O(L) where L is the length of the linked list (one pass).
 * Space Complexity: O(1) as we only use a constant amount of extra space.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// First Solution

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        temp = head;

        if (size == 1) {
            return null;
        }

        if (size - n == 0) {
            return head.next;
        }

        for (int i = 0; i < size - n - 1; i++) {
            temp = temp.next;
        }
        ListNode nextNode = temp.next;
        if (temp.next != null) {
            temp.next = nextNode.next;
        }
        return head;
    }
}

// After hint - Maintain two pointers and update one with a delay of n steps.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge case where head needs to be removed
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        // Move second pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            second = second.next;
        }

        // Move both pointers until second reaches the end
        while (second != null) {
            second = second.next;
            first = first.next;
        }
        // first is now pointing to the node before the one to be removed
        first.next = first.next.next;
        return dummy.next;
    }
}
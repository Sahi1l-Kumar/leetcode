/**
 * Problem: 876. Middle of the Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 * Description:
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: head = [1][2][3][4][5]
 * Output: [3][4][5]
 * Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 * Input: head = [1][2][3][4][5][6]
 * Output: [4][5][6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Constraints:
 * The number of nodes in the list is in the range [1].
 * 1 <= Node.val <= 100
 *
 * Approach:
 * Use the "slow and fast pointer" (tortoise and hare) technique:
 * 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list
 * 2. Move the slow pointer one step at a time and the fast pointer two steps at a time
 * 3. When the fast pointer reaches the end of the list, the slow pointer will be at the middle
 * 4. For even-length lists, this automatically returns the second middle node
 * 
 * Time Complexity: O(n) where n is the number of nodes in the linked list
 * Space Complexity: O(1) as we only use two pointers regardless of list size
 */

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

// Solution 1

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
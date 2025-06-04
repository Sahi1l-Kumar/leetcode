/**
 * Problem: Add Two Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-two-numbers/
 *
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 * Approach:
 * 1. Use a dummy head node to simplify the process of building the result linked list.
 * 2. Traverse both input linked lists simultaneously, adding corresponding digits and carry.
 * 3. Continue until all nodes are processed and there's no remaining carry.
 * 4. Handle cases where one list is longer than the other.
 * 
 * Time Complexity: O(max(m, n)) where m and n are the lengths of the two linked lists.
 * Space Complexity: O(max(m, n)) for the result linked list.
 */

// Solution 1

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        return result.next;
    }
}

// Solution 2 (What I was initially trying to come up with)

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
class Solution {
    public int createNode(ListNode head, int val) {
        int carryOver = 0;
        if (val > 9) {
            carryOver = val / 10;
            val %= 10;
        }
        if (head.next == null) {
            ListNode node = new ListNode(val);
            head.next = node;
            node.next = null;
            return carryOver;
        }
        while (head.next != null) {
            head = head.next;
        }
        ListNode node = new ListNode(val);
        head.next = node;
        node.next = null;
        return carryOver;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        sum.val = l1.val + l2.val;
        sum.next = null;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            int carryOver = createNode(sum, l1.val + l2.val);
        }
        return sum;
    }
}

// Fixed the above one with this

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

class Solution {
    public int createNode(ListNode head, int val) {
        int carryOver = 0;
        if (val > 9) {
            carryOver = val / 10;
            val %= 10;
        }

        // Move to the end of the list
        while (head.next != null) {
            head = head.next;
        }

        ListNode node = new ListNode(val);
        head.next = node;
        return carryOver;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sumVal = l1.val + l2.val;
        int carry = sumVal / 10;
        ListNode sum = new ListNode(sumVal % 10);

        ListNode p1 = l1.next;
        ListNode p2 = l2.next;

        while (p1 != null || p2 != null || carry > 0) {
            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;

            int total = val1 + val2 + carry;
            carry = createNode(sum, total);

            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }

        return sum;
    }
}
/**
 * Problem: 27. Remove Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-element/
 *
 * Description:
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place. The order of the elements may be changed. Then return the
 * number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to
 * get accepted, you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val. The remaining elements of nums are not
 * important as well as the size of nums.
 * - Return k.
 *
 * Example 1:
 * Input: nums = , val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 *
 * Example 2:
 * Input: nums = , val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 *
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 * Approach:
 * Use two pointers technique:
 * 1. Use a slow pointer to track the position where the next valid element
 * should be placed
 * 2. Use a fast pointer to iterate through the array
 * 3. When the fast pointer finds an element not equal to val, copy it to the
 * slow pointer position
 * 4. Increment the slow pointer only when we find a valid element
 * 5. Return the slow pointer value which represents the count of valid elements
 * 
 * Time Complexity: O(n) where n is the length of the nums array
 * Space Complexity: O(1) as we only use constant extra space
 */

// Solution 1

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1, count = 0;
        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                } else {
                    nums[i] = nums[j];
                    nums[j] = Integer.MIN_VALUE;
                    count++;
                    i++;
                    j--;
                }
            } else {
                if (nums[j] == val) {
                    i++;
                    j--;
                    count++;
                } else {
                    i++;
                    count++;
                }
            }
        }
        return count;
    }
}

// Solution 2 (Refactored)

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
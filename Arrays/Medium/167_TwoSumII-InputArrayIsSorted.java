/*
 * Problem: 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Description:
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <=
 * index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * Your solution must use only constant extra space.
 *
 * Example 1:
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
 * return [1, 2].
 * 
 * Example 2:
 * 
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
 * return [1, 3].
 * 
 * Example 3:
 * 
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
 * return [1, 2].
 *
 * 
 * Constraints:
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 *
 * Approach:
 * Use two pointers technique since the array is sorted:
 * 1. Initialize left pointer at the beginning and right pointer at the end
 * 2. Calculate the sum of elements at both pointers
 * 3. If sum equals target, return the 1-indexed positions
 * 4. If sum is less than target, move left pointer right to increase sum
 * 5. If sum is greater than target, move right pointer left to decrease sum
 * 6. Continue until we find the solution
 * 
 * Time Complexity: O(n) where n is the length of the numbers array
 * Space Complexity: O(1) as we only use constant extra space
 */

// Solution 1 (Two Pointer)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            while (i > 0 && numbers[i] == numbers[i - 1]) {
                i++;
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
}

// Solution 2 (Refactored)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }
        return new int[] {};
    }
}
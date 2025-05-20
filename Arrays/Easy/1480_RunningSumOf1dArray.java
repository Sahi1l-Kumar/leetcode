/**
 * Problem: 1480. Running Sum of 1d Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/description/
 *
 * Description:
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 * Example 2:
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 *
 * Example 3:
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 *
 * Approach:
 * We can solve this by iterating through the array and keeping a running sum.
 * For each position i, we add the current number to the running sum and store it at position i.
 * This is an in-place modification of the input array.
 * 
 * Time Complexity: O(n) where n is the length of the array
 * Space Complexity: O(1) if we don't count the output array, O(n) if we do
 */

// Solution 1

class Solution {
    public int[] runningSum(int[] nums) {
        int runningSum[] = new int[nums.length];
        runningSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            for(int j = i; j >= 0; j--) {
                runningSum[i] += nums[j];
            }
        }
        return runningSum;
    }
}

// Solution 2

class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        // Edge case: if array is empty or has only one element, return it as is
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        // Calculate running sum in-place
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        return nums;
    }
}

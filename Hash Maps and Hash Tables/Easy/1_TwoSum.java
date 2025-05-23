
/**
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/description/
 *
 * Description:
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time
 * complexity?
 *
 * Approach 1 (Brute Force):
 * Check every pair of numbers to see if they sum to the target.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Approach 2 (HashMap - Optimal):
 * Use a HashMap to store numbers we've seen and their indices.
 * For each number, check if its complement (target - current number) exists in
 * the map.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

// Solution 1 (Arrays)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int answer[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }
}

// Solution 2 (Two pass Hash Tables)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int answer[] = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if (hashMap.containsKey(y) && i != hashMap.get(y)) {
                answer[0] = i;
                answer[1] = hashMap.get(y);
                break;
            }
        }

        return answer;
    }
}

// Solution 3 (One Pass Hash Tables)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int x = target - nums[i];

            if (hashMap.containsKey(x)) {
                return new int[] { i, hashMap.get(x) };
            }
            hashMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
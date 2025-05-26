/**
 * Problem: 11. Container With Most Water
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/container-with-most-water/
 *
 * Description:
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height =
 * Output: 49
 * Explanation: The above vertical lines are represented by array . In this
 * case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height =
 * Output: 1
 *
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 *
 * Approach:
 * Use two pointers technique:
 * 1. Start with pointers at the beginning and end of the array
 * 2. Calculate the area formed by the current two lines
 * 3. Move the pointer with the smaller height inward (since moving the taller
 * one won't increase area)
 * 4. Keep track of the maximum area seen so far
 * 5. Continue until the pointers meet
 * 
 * Time Complexity: O(n) where n is the length of the height array
 * Space Complexity: O(1) as we only use constant extra space
 */

// Solution 1 (Two Pointer)

class Solution {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxArea = Integer.MIN_VALUE, length = height.length - 1, breadth = 0;
        while (i <= j) {
            if (height[i] <= height[j]) {
                breadth = height[i];
            } else {
                breadth = height[j];
            }
            int area = length * breadth;
            if (area > maxArea)
                maxArea = area;
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
            length--;
        }
        return maxArea;
    }
}

// Solution 2 (Better way to calculate)

class Solution {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (i <= j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
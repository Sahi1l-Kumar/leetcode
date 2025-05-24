/**
 * Problem: 4. Median of Two Sorted Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * Description:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 */

// Solution 1 (Merge Sort)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mergedArr[] = new int[m + n];
        int l = mergedArr.length;

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mergedArr[k] = nums1[i];
                i++;
                k++;
            } else {
                mergedArr[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            mergedArr[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            mergedArr[k] = nums2[j];
            j++;
            k++;
        }

        return (m + n) % 2 == 0 ? ((double) (mergedArr[(l / 2 - 1)] + mergedArr[(l / 2)]) / 2) : mergedArr[l / 2];
    }
}

// Solution 2 (Two Pointer Approach)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, curr = 0, prev = 0;

        for (int count = 0; count <= (m + n) / 2; count++) {
            prev = curr;
            if (i != m && j != n) {
                if (nums1[i] > nums2[j]) {
                    curr = nums2[j++];
                } else {
                    curr = nums1[i++];
                }
            } else if (i < m) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        return (m + n) % 2 != 0 ? (double) curr : ((double) (prev + curr) / 2);
    }
}
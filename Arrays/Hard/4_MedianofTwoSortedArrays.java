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

// Solution 3 (Binary Search)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1; // Calculate mid index for nums1
            int mid2 = left - mid1; // Calculate mid index for nums2

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Determine values of l1, l2, r1, and r2
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                // The partition is correct, we found the median
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            } else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }

        return 0; // If the code reaches here, the input arrays were not sorted.
    }
}

// Solution 4 (More readable solution)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int A = nums1.length;
        int B = nums2.length;

        if (A > B) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0, r = A;
        int total = A + B;
        int half = (total + 1) / 2;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int ALeft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int ARight = (i == A) ? Integer.MAX_VALUE : nums1[i];
            int BLeft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int BRight = (j == B) ? Integer.MAX_VALUE : nums2[j];

            if (ALeft <= BRight && BLeft <= ARight) {
                if (total % 2 == 0) {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                } else {
                    return Math.max(ALeft, BLeft);
                }
            } else if (ALeft > BRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0.0; // Should not reach here
    }
}

```java
/**
 * Problem: 9. Palindrome Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/palindrome-number/
 *
 * Description:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints:
 * -2^31 reversedHalf`:
 * - `reversedHalf = reversedHalf * 10 + x % 10`
 * - `x /= 10`
 * 3. After the loop:
 * - If the original number `x` had an odd number of digits, the middle digit
 * will be left in `x`.
 * So, we compare `x` with `reversedHalf / 10`.
 * - If the original number `x` had an even number of digits, `x` should be
 * equal to `reversedHalf`.
 * - We can combine these checks: `x == reversedHalf || x == reversedHalf / 10`.
 *
 * Time Complexity: O(log10(n)) - We divide the input by 10 in each step.
 * Space Complexity: O(1) - We only use a few variables.
 */

 // Solution 1 

 class Solution {
    public int countDigits(int x) {
        int count = 0;
        while(x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    public boolean isPalindrome(int x) {
        if(x < 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return false;
        }

        int sum = 0, y = x;
        int p = countDigits(y);

        while (y > 0) {
            int d = y % 10;
            y /= 10;
            sum += d * Math.pow(10, --p);
        }
        return sum == x;
    }
}

// Solution 2 (Refactored)

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) { 
            return false;
        }

        int xcopy = x, reversedNumber = 0;
        while(x > 0) {
            reversedNumber = (reversedNumber * 10) + (x % 10);
            x /= 10;
        }
        return xcopy == reversedNumber;
    }
}

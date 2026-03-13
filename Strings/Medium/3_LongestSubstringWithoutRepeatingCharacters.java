
/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Link:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Description:
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 *
 * Approach:
 * Use the sliding window technique with a HashMap to store the last index of
 * each character.
 * 1. Initialize a HashMap to store the last seen index of each character.
 * 2. Use two pointers: left (start of window) and right (end of window).
 * 3. As you iterate with right, if the character is already in the map and its
 * last seen index is >= left,
 * move left to last seen index + 1 to avoid duplicates.
 * 4. Update the character's last seen index in the map.
 * 5. Update the maximum window length at each step.
 * 
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(min(n, m)), where m is the size of the character set.
 */

// Solution 1 (Time Limit Exceeded)

class Solution {
    private boolean isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                return false;
            }
            map.put(s.charAt(i), i);
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isValid(sub)) {
                    if (sub.length() > maxLength) {
                        maxLength = sub.length();
                    }
                }
            }
        }
        return maxLength;
    }
}

// Solution 2 (Sliding Window + HashMap)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
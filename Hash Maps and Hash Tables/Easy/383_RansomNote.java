/**
 * Problem: 383. Ransom Note
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/ransom-note/
 *
 * Description:
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 *
 * Approach:
 * 1. Count the frequency of each character in the magazine
 * 2. Iterate through the ransomNote and decrement the count for each character
 * 3. If at any point the count becomes negative, return false
 * 4. If we can process the entire ransomNote without issues, return true
 * 
 */

// Solution 1

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        HashMap <Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int val = hashMap.getOrDefault(c, 0);
            hashMap.put(c, val + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int characterCount = hashMap.getOrDefault(c, 0);
            if(characterCount == 0) {
                return false;
            }
            hashMap.put(c, characterCount - 1);
        }
        return true;
    }
}

// Solution 2 (Using arrays)

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        int count[] = new int [26];

        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            count[c - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(--count[c - 'a'] < 0) return false;
        }
        return true;
    }
}
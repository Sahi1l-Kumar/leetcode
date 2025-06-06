/**
 * Problem: 1672. Richest Customer Wealth
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/richest-customer-wealth/description/
 *
 * Description:
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank.
 * Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 *
 * Example 1:
 * Input: accounts = [[1,2,3],[3,2,1]]
 * Output: 6
 * Explanation:
 * 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6.
 *
 * Example 2:
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation: 
 * 1st customer has wealth = 6
 * 2nd customer has wealth = 10 
 * 3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 *
 * Example 3:
 * Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * Output: 17
 *
 * Constraints:
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 *
 * Approach:
 * 1. Iterate through each customer (row) in the accounts array
 * 2. For each customer, calculate their total wealth by summing all their bank accounts
 * 3. Keep track of the maximum wealth seen so far
 * 4. Return the maximum wealth
 * 
 * Time Complexity: O(m*n) where m is the number of customers and n is the number of banks
 * Space Complexity: O(1) as we only use a constant amount of extra space
 */

// Solution 1

class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        if(accounts == null || m == 0) {
            return -1;
        }
        int maxWealth = Integer.MIN_VALUE;
        for(int i = 0; i < m; i ++) {
            int wealth = 0;
            for(int j = 0; j < n; j++) {
                wealth += accounts[i][j];
            }
            if(wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}

// Solution 2

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int[] customer: accounts) {
            int currentWealth = 0;
            for(int bank: customer) {
                currentWealth += bank;
            }
            maxWealth = Math.max(currentWealth, maxWealth);
        }
        return maxWealth;
    }
}
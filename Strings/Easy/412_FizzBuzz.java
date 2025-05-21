/**
 * Problem: 412. Fizz Buzz
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fizz-buzz/description/
 *
 * Description:
 * Given an integer n, return a string array answer (1-indexed) where:
 * - answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * - answer[i] == "Fizz" if i is divisible by 3.
 * - answer[i] == "Buzz" if i is divisible by 5.
 * - answer[i] == i (as a string) if none of the above conditions are true.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 *
 * Example 2:
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 *
 * Example 3:
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
**/

// Solution 1

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                answer.add("Fizz");
            }
            else if(i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(Integer.toString(i));
            }
        }
        return answer;
    }
}

// Solution 2 (String concatenation)

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);

        for(int i = 1; i <= n; i++) {
            String currStr = "";
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            if(divisibleBy3) {
                currStr += "Fizz";
            }
            if(divisibleBy5) {
                currStr += "Buzz";
            }
            if(currStr.isEmpty()) {
                currStr += i;
            }
            answer.add(currStr);
        }
        return answer;
    }
}

// Solution 3 (Ternary Operator)

class Solution {
    public List fizzBuzz(int n) {
        List ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            ans.add(
                i % 15 == 0 ? "FizzBuzz" :
                i % 5 == 0  ? "Buzz" :
                i % 3 == 0  ? "Fizz" :
                String.valueOf(i)
            );
        }

        return ans;
    }
}

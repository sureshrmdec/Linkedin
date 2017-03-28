/*
Total Accepted: 183751
Total Submissions: 736114
Difficulty: Medium
Contributors: Admin
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

*/

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s == null || s.length() == 0){
            return res;
        }
        
        int m =  s.length();
        boolean[][] dp = new boolean[m][m];
        
        
        int count = 0;
        
        
        for(int j = 0; j < m; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && ((j - i <= 2 ||  dp[i + 1][j - 1]))){
                    dp[i][j] = true;
                    if(j - i + 1 > count){   
                        res = s.substring(i, j + 1);
                    
                        count = j - i + 1;
                    }
                }
            }
        }
        
        return res;
        
    }
}

List<String> = new ArrayList<>();

for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
        if(dp[i][j]){
            res.add(s.substring(i, j - i + 1));
        }
    }
}

return res;

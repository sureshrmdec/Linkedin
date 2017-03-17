/*
Total Accepted: 50401
Total Submissions: 151063
Difficulty: Medium
Contributors: Admin
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

*/

public class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int one = getRob(nums, 0, nums.length - 2);
        
        int two = getRob(nums, 1, nums.length - 1);
        
        return Math.max(one, two);
        
        

    }
    
    private int getRob(int[] nums, int st, int ed){
        
        if(st == ed){
            return nums[st];
        }
        
        
        int n = nums.length;
        
        int[] dp = new int[n];
        
        
        dp[st] = nums[st];
        
        dp[st + 1] = Math.max(nums[st], nums[st + 1]);
        
        for(int i = st + 2; i <= ed; i++){
            
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
  
        }
        
        return dp[ed];
        
    } 
}

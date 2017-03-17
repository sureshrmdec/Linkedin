/*

Total Accepted: 452343
Total Submissions: 1429501
Difficulty: Easy
Contributors: Admin
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
Show Company Tags
Show Tags
Show Similar Problems


*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int[] res = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(nums[i])){
                int m = map.get(nums[i]);
                res[0] = m;
                res[1] = i;
                
                return res;
            }else{
                
                map.put(target - nums[i], i);
            }
        }
        
        return res;
        
    }
}

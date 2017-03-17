/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int st = 0;
        int ed  = nums.length - 1;
        
        while(st + 1 < ed){
            
            while(st + 1 < ed && nums[st] == nums[st + 1]){
                st++;
            }
            
            while(st + 1 < ed && nums[ed] == nums[ed - 1]){
                ed--;
            } 
            
            int mid = st + (ed - st) / 2;
            
            if(nums[st]  <= nums[mid]){
                if(nums[st] <= target && target <= nums[mid]){
                    ed = mid;
                }else{
                    st = mid;
                }
            }
            
            if(nums[st] > nums[mid]){
                if(nums[mid] <= target && target <= nums[ed]){
                    st = mid;
                }else{
                    ed = mid;
                }
            }
        }
                          
        if(nums[st] == target){
            return st;
        }else if (nums[ed] == target){
            return ed;
        }else{
            return -1;
        }

        
        
    }
    
}

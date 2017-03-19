/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems


*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    
    
    private int helper(int[] nums, int st , int ed, int k){
        
        if(st == ed){
            return nums[st];
        }
        
        int pos = getKth(nums, st, ed);
        
        if(pos == k){
            return nums[pos];
        }else if(pos < k){
            return helper(nums, pos + 1, ed, k);
        }else{
            return helper(nums, st, pos - 1, k);
        }

    }
    
    private int getKth(int[] nums, int st, int ed){
        
        int left = st;
        int right = ed;
        
        int pivot = nums[ed];
        
        
        while(left < right){
            
            while(left < right && nums[left] < pivot){
                left++;
            }
            
            while(left < right && nums[right] >= pivot){
                right--;
            }
            
            swap(nums, left, right);
        
        }
        
        swap(nums, left, ed);
        
        return left;
        
    }
    
    private void swap(int[] nums, int left , int right){
        
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        
    }
}

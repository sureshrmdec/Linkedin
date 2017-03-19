/*
Total Accepted: 115823
Total Submissions: 485486
Difficulty: Easy
Contributors: Admin
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  

*/

public class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        
        change(nums, 0, nums.length - 1);
        change(nums, 0, k - 1);
        change(nums, k, nums.length - 1);
        
    }
    
    
    private void change(int[] nums, int st, int ed){
        while(st < ed){
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++;
            ed--;
        }
    }
}

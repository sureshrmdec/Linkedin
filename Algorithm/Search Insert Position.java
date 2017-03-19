/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Show Tags
Show Similar Problems


*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        
        if(A.length == 0 || target < A[0]){
            return 0;
        }
        
        if(target > A[A.length - 1]){
            return A.length;
        }
        
        int i = 0;
        
        int j = A.length - 1;
        
        while(i + 1 < j){
            int mid = i + (j - i) / 2;
            
            if(A[mid] == target){
                return mid;
            }
            
            if(A[mid] > target){
                j = mid;
            }else{
                i = mid;
            }
        }
        
        if(A[i] == target){
            return i;
        }else{
            return j;
        }
        
    }
}

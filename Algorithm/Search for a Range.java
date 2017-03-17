/*

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        
        int[] res = {-1,-1};
        
        if(A == null || A.length == 0){
            return res;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            if(A[mid] == target){
                int j = mid;
                int k = mid;
                while(j > start && A[j] == A[j -1]){
                    j--;
                }
                while(k < end && A[k] == A[k + 1]){
                    k++;
                }
                
                res[0] = j;
                res[1] = k;
                return res;
            } 
            
            else if(A[mid] > target){
                end = mid;
            }else{
                start = mid;
            }

        }
        if(A[start] == target && A[end] == target){
            res[0] = start;
            res[1] = end;
            return res;
        }
        
        if(A[start] == target && A[end] != target){
            res[0] = start;
            res[1] = start;
            return res;
        }
        
        if(A[start] != target && A[end] == target){
            res[0] = end;
            res[1] = end;
            return res;
        }
        
        return res;
    }
}

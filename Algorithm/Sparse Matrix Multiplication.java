/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
Show Company Tags
Show Tags


*/

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        if(A == null || A.length == 0 || A[0].length == 0){
            return null;
        }
        
        if(B == null || B.length == 0 || B[0].length == 0){
            return null;
        }
        
        int m = A.length;
        int n = B[0].length;
        
        int[][] res = new int[m][n];
        
        
        for(int i = 0; i < m; i++){
            
            for(int k = 0; k < A[i].length; k++){
                
                if(A[i][k] != 0){
                    for(int j = 0; j < n; j++){
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }

            }
        }
        
        return res;
    }
}







public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        
        if(A == null || A.length == 0 || A[0].length == 0){
            return null;
        }
    
        if(B == null || B.length == 0 || B[0].length == 0){
            return null;
        }
        
        int m = A.length;
        int n = B[0].length;
        
        
        int[][] res = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int k = 0; k < A[0].length; k++){
                if(A[i][k] != 0){
                    for(int j = 0; j < n; j++){
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        return res;
    }
}






    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DotProduct sol = new DotProduct();
        int[][] v2 = new int[][]{{0, 2}, {1, 3}, {5, 2}, {7, 1}, {10, 1}};
        int[][] v1 = new int[][]{{1, 6}, {7, 2}};
        int res = sol.dotPro(v1, v2);
        System.out.println(res);
    }

    static class DotProduct {
        public int dotPro(int[][] v1, int[][] v2) {
            int[][] shortV;
            int[][] longV;
            if (v1.length < v2.length) {
                shortV = v1;
                longV = v2;
            } else {
                shortV = v2;
                longV = v1;
            }

            int res = 0;
            for (int[] aShortV : shortV) {
                int shortIndex = aShortV[0];
                int shortValue = aShortV[1];
                int longSeq = binarySearch(longV, shortIndex);
                if (longSeq >= 0) {
                    res += shortValue * longV[longSeq][1];
                }
            }
            return res;
        }

        public int binarySearch(int[][] arr, int target) {
            int l = 0, r = arr.length - 1;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;

                if (arr[mid][0] == target) {
                    return mid;
                } else if (arr[mid][0] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

                if (arr[l][0] == target) {
                    return l;
                } else if (arr[r][0] == target) {
                    return r;
                }


            }

            return -1;
        }


    }

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Show Tags
Show Similar Problems

*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int m = matrix.length;

        int n = matrix[0].length;

        int total = m * n - 1;

        return search(0,total, m, n, target, matrix);

    }


    public boolean search(int begin, int end, int row, int col, int target, int matrix[][]) {

        if (begin > end) return false;
        int mid = begin + (end - begin) / 2;

        int r = mid / col;
        int c = mid % col;

        if (matrix[r][c] == target) return true;

        if (target < matrix[r][c]) {
            return search(begin, mid - 1, row, col, target, matrix);
        } else {
            return search(mid + 1, end, row, col, target, matrix);
        }

    }
}

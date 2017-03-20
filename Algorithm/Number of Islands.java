/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/
public class Solution {
    
    int[] xs = new int[]{1, 0, -1, 0};
    int[] ys = new int[]{0, 1, 0, -1};
    
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    
    private void helper(char[][] grid, int i, int j){
        
        grid[i][j] = '0';
        
        for(int k = 0; k < 4; k++){
            int x = i + xs[k];
            int y = j + ys[k];
            
            if(x >=0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                helper(grid, x, y);
            }
        }
        
    }
}

/*
ferent. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

Show Company Tags
Show Tags
Show Similar Problems


*/
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        int min1 = -1;
        int min2 = -1;
        
        int m = costs.length;
        int n = costs[0].length;
        
        for(int i = 0; i < m; i++){

            
                   
            int last1 = min1;
            int last2 = min2;
            
            min1 = -1;
            min2 = -1;
            
            for(int j = 0; j < n; j++){
                
                if(j != last1){
                    costs[i][j] += last1 >=0 ? costs[i - 1][last1] : 0;
                }else{
                    costs[i][j] += last2 >=0 ? costs[i - 1][last2] : 0;
                }
                
                if(min1 == -1 || costs[i][j] < costs[i][min1]){
                    
                    min2 = min1;
                    min1 = j;
                }else if(min2 == -1 || costs[i][j] < costs[i][min2]){
                    
                    min2 = j;
                }
            }
        }
        
        return costs[m - 1][min1];
    }
}

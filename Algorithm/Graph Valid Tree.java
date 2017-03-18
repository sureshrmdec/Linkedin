/*
Total Accepted: 31840
Total Submissions: 85638
Difficulty: Medium
Contributors: Admin
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Show Hint 
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

*/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int[] nums = new int[n];
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = i;
        }
        
        for(int i = 0 ; i < edges.length; i++){
            int left = unionFound(nums, edges[i][0]);
            int right = unionFound(nums, edges[i][1]);
            
            if(left == right){
                return false;
            }
            
            nums[right] = left;
        }
        
        return edges.length + 1 == n;
        
        
    }
    
    private int unionFound(int[] nums, int e){
        if(nums[e] != e){
            return unionFound(nums, nums[e]);
        }
        
        return e;
    }
    
}

/*
Total Accepted: 221633
Total Submissions: 430690
Difficulty: Easy
Contributors: Admin
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        
        
        if(root == null){
            return 0;
        }
        
        
        return helper(root);
        
    }
    
    private int helper(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        return Math.max(left, right) + 1;
    }
}

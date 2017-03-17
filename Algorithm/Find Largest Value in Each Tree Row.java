/*
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
Show Company Tags
Show Tags



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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size  = q.size();
            
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++){
                
                TreeNode temp = q.poll();
                
                max = Math.max(temp.val, max);
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                }
                
            }
            
            res.add(max);
        }
        
        return res;
        
    }
}

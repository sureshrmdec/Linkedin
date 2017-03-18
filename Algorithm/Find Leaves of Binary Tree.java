/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        helper(root, res);
        
        
        return res;
    }
    
    
    private int helper(TreeNode root, List<List<Integer>> res){
        
        if(root == null){
            return -1;
        }
        
        int lev = 1 + Math.max(helper(root.left, res), helper(root.right, res));
        
        if(res.size() == lev){
            res.add(new ArrayList<Integer>());
        }
        res.get(lev).add(root.val);
        
        return lev;
    }
}

/*
Total Accepted: 90318
Total Submissions: 305835
Difficulty: Medium
Contributors: Admin
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Show Company Tags
Show Tags
Show Similar Problems


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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        
        
        return helper(root, p, q);
    
    }
    
    private TreeNode helper(TreeNode root, TreeNode p , TreeNode q){
        
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = helper(root.left, p, q);
        
        TreeNode right = helper(root.right ,p , q);
        
        
        if(left != null && right != null){
            return root;
        }
        
        if(left != null){
            return left;
        }
        
        if(right != null){
            return right;
        }
        
        return null;
        
        
    }
}

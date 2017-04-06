/*

Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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
  
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        if(root == null){
            return root;
        }
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;   
        TreeNode temp = null; 
        
        while(curr != null){
            
           next = curr.left;
           curr.left = temp;
           temp = curr.right;
           curr.right = prev;
           
           
           prev = curr;
           curr = next;
        }
        
        return prev;
    }
}


public class UpsidedownBinaryTree {
    public Node upsideDownBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        return upsideDownBinaryTree(root, null, null);
    }

    public Node upsideDownBinaryTree(Node root, Node parent, Node rightChild) {
        if (root == null) {
            return parent;
        }
        Node left = root.left;
        Node right = root.right;

        root.right = parent;
        root.left = rightChild;

        return upsideDownBinaryTree(left, root, right);
    }
}

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }   
        
        TreeNode temp = upsideDownBinaryTree(root.left);


        root.left.left = root.right;
        root.left.right = root;
        
        root.left = null;
        root.right = null;
        
        return temp;
        
    }
}

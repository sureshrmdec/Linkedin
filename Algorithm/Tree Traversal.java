/*

Binary Tree Inorder Traversal

recursion

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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();

        inOrderTraversal(root, res);
        return res;
    }


    public void inOrderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrderTraversal(root.left, res);
            res.add(root.val);
            inOrderTraversal(root.right, res);
        }
    }
}


/*
stack
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || !stack.isEmpty()){
            
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                res.add(stack.peek().val);
                root = stack.pop().right;
            }
        }
        
        return res;
        
    }
}




/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},


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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        
        List<Integer> res = new ArrayList<Integer>();
        
        helper(root, res);
        
        return res;
    }
    private void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        
        res.add(root.val);
        
        helper(root.left,res);
        helper(root.right,res);
        
        
    }
}


public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.add(root);
        
        while(!stack.isEmpty()){
            
            TreeNode node = stack.pop();
            res.add(node.val);
            
            if(node.right != null){
                stack.add(node.right);
            }
            
            if(node.left != null){
                stack.add(node.left);
            }
        }
        
        return res;
        
    }
}

/*

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

Subscribe to see which companies asked this question


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
	public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> stack  = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.left == null && temp.right == null){
                TreeNode pop = stack.pop();
                res.add(pop.val);
            }else{
                if(temp.right != null){
                    stack.add(temp.right);
                    temp.right = null;
                }
                
                if(temp.left != null){
                    stack.add(temp.left);
                    temp.left = null;
                }
            }
        }
        return res;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        
        List<Integer> res = new ArrayList<Integer>();
        helper(res,root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root){
        
        if(root == null){
            return;
        }
        
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}

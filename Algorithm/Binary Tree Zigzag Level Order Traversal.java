/*
Total Accepted: 91449
Total Submissions: 276738
Difficulty: Medium
Contributors: Admin
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res= new ArrayList<List<Integer>>();
        List<Integer> r = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return res;
        q.add(root);
        q.add(null);
        boolean flag = true;

        while(!q.isEmpty()){
            TreeNode temp = q.peek();
            q.remove();
            if(temp != null){
                r.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right !=null) q.add(temp.right);
            }else{
                
                List<Integer> result = new ArrayList<Integer>(r);

                if(!flag) {
                    Collections.reverse(result);
                }
                res.add(result);
                flag = !flag;
                if(!q.isEmpty()){
                    r.clear();
                    q.add(null);
                }

            }
          
        }
        return res;

    }
}

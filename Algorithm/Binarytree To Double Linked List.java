class NodeRef{
  Node node;
}


public class BinaryTreeToDoubleLinkList {

    public void toDoubleLL(Node root){
        NodeRef prev = new NodeRef();
        toDoubleLL(root,prev);
    }
    
    private void toDoubleLL(Node root, NodeRef prev){
        if(root == null){
            return;
        }
        toDoubleLL(root.left,prev);
        if(prev.node != null){
            prev.node.right = root;
            root.left = prev.node;
            prev.node = root;
        }else{
            prev.node = root;
        }
        toDoubleLL(root.right,prev);
    }
}

public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if (root == null) {
            return null;
        }
        //Init stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;    
        stack.push(node);
        //Create DoublyListNode header
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode head = dummy;
        
            
        while(!stack.isEmpty()) {
            while (node != null && node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            //add node
            node = stack.pop();
            DoublyListNode curr = new DoublyListNode(node.val);
            head.next = curr;
            curr.prev = head;
            head = head.next;
            
            //check right node and add to stack
            node = node.right;
            if (node != null) {
                stack.push(node);
            }  
        }
        
        return dummy.next;
        
    }
}

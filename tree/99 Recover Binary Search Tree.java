/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    TreeNode currNode = null;
    TreeNode[] nodeToReplace = new TreeNode[2];
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = nodeToReplace[0].val;
        nodeToReplace[0].val = nodeToReplace[1].val;
        nodeToReplace[1].val = temp;
    }
    
    public void traverse(TreeNode node) {
        if(node == null) return;
        
        traverse(node.left);
        
        if(currNode == null) {
            currNode = node;
        } else {
            if(node.val < currNode.val) {
                if(nodeToReplace[0] == null) {
                    nodeToReplace[0] = currNode;
                    nodeToReplace[1] = node;
                } else {
                    nodeToReplace[1] = node;
                }
            } 
            currNode = node;
        }
        
        traverse(node.right);
    }
}

/*

    1 3 2 4
    


*/

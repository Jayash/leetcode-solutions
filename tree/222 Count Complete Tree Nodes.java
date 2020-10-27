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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int h = 1;
        
        Node node = new Node(root, 1);
        
        while(node.treeNode.left != null && node.treeNode.right != null) {
            if(isSameHeight(node.treeNode.left, node.treeNode.right)) {
                node = new Node(node.treeNode.right, 2 * node.index + 1);
            } else node = new Node(node.treeNode.left, 2 * node.index);
        }

        if(node.treeNode.left == null) return node.index;
        
        return 2 * node.index;
    }
    
    public boolean isSameHeight(TreeNode node1, TreeNode node2) {
        
        while(node1.left != null && node2.left != null) {
            node1 = node1.left;
            node2 = node2.left;
        }
        
        if(node1.left == null) return true;
        
        return false;
    }
}

class Node {
    TreeNode treeNode;
    int index;
    public Node(TreeNode node, int index) {
        this.treeNode= node;
        this.index = index;
    }
}

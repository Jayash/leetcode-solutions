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
        
        while(root.left != null && root.right != null) {
            if(isSameHeight(root.left, root.right)) {
                root = root.right;
                h = 2 * h + 1;
            } else {
                root = root.left;
                h = 2 * h;
            }
        }

        if(root.left == null) return h;
        
        return 2 * h;
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

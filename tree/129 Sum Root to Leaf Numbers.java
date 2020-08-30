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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sumNumbers(root, 0);
        return sum;
    }
    
    public void sumNumbers(TreeNode root, int num) {
        if(root.left == null && root.right == null) {
            sum += (num*10 + root.val);
            return;
        }
        
        if(root.left != null) sumNumbers(root.left, num*10 + root.val);
        if(root.right != null) sumNumbers(root.right, num*10 + root.val);
    }
}

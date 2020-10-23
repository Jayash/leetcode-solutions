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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return ans-1;
    }
    
    public int dfs(TreeNode node) {
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        int max = 1;
        if(node.left != null && node.val == node.left.val)
            max = Math.max(max, 1 + left);
        
        if(node.right != null && node.val == node.right.val) {
            max = Math.max(max, 1 + right);
            
            if(node.left != null && node.val == node.left.val)
                ans = Math.max(ans, 1 + left + right);
        }
        
        ans = Math.max(ans, max);
       
        return max;
    }
}

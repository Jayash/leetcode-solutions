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
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int res[] = dp(root);
        return Math.min(res[0], res[1]);
        
    }
    
    public int[] dp(TreeNode node) {
        if(node == null) return new int[]{0, 99999, 0};
        
        
        int[] left = dp(node.left);
        int[] right = dp(node.right);
        
        int a = Math.min(left[1] + Math.min(right[0], right[1]), right[1] + Math.min(left[0], left[1]));
        int b = 1 + Math.min(left[0], Math.min(left[1], left[2])) 
                            + Math.min(right[0], Math.min(right[1], right[2]));
                
        int c = left[0] + right[0];
        
        return new int[]{a, b, c};
    }
}


/*

 a = node does not has a camera
 b = node has a camera
 c = node is not monitered but all the child node are monitered

            0 1, 
        /       \
       0         0  1, 1, 999
   99,1,0         \
                   0 999, 1, 0

*/

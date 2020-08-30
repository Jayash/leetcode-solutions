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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        
        if(start > end) return null;
        
        List<TreeNode> res = new ArrayList<>();
        
        for(int i=start; i<=end; i++) {

            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);
            
            if(left == null && right == null) {
                TreeNode curr = new TreeNode(i);
                res.add(curr);
            } else if(right == null) {
                for(int j=0; j< left.size(); j++) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left.get(j);
                    res.add(curr);
                }
            } else if(left == null) {
                for(int j=0; j< right.size(); j++) {
                    TreeNode curr = new TreeNode(i);
                    curr.right = right.get(j);
                    res.add(curr);
                }
            } else {
                for(int j=0; j< left.size(); j++) {
                    for(int k=0; k< right.size(); k++) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = left.get(j);
                        curr.right = right.get(k);
                        res.add(curr);
                    }
                }
            }    
        }
        
        return res;
    }
}


// 1 2 3
/*
    0 2
    
    0 23

*/

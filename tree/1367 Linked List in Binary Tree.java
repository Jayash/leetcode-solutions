/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        
        return isSubPath(head, root, new ArrayList<ListNode>());
        
    }
    
    public boolean isSubPath(ListNode head, TreeNode root, List<ListNode> ll) {
        if(root == null) return false;
        
        List<ListNode> nextList = new ArrayList<>();
        
        if(root.val == head.val) {
            nextList.add(head);
            if(head.next == null) return true;
        }
        
        for(ListNode node : ll) {
            if(node.next.val == root.val) {
                nextList.add(node.next);
                if(node.next.next == null) return true;
            }
        }
        
        return isSubPath(head, root.left, nextList) ||
        isSubPath(head, root.right, nextList);
    }
}

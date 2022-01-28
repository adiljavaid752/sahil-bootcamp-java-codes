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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
//         if(root == null){
//             return new TreeNode(val);
//         }
        
//         if(root.val > val){
//             root.left = insertIntoBST(root.left, val);
//         }
//         else{
//             root.right = insertIntoBST(root.right, val);
//         }        
        
//         return root;
        
        TreeNode current = root;
        TreeNode prev = null;
        
        while(current != null){
            
            if(current.val > val){
                prev = current.left;
                current = prev;
            }
            else{
                prev = current.right;
                current = prev;
            }  
        }
        
        prev = new TreeNode(val);
        
        return root;
        
    }
}

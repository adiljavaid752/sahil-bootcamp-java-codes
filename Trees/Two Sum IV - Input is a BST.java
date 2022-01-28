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
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> traversal = new ArrayList<>();
        inorderTraversal(root, traversal);
        
        int left = 0;
        int right = traversal.size() - 1;
        
        while(left < right){
            if(traversal.get(left) + traversal.get(right) == k){
                return true;
            }
            else if(traversal.get(left) + traversal.get(right) < k){
                left++;
            }
            else{
                right--;
            }
        }
        
        return false;
        
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> traversal){
        
        if(root == null){
            return;
        }
        
        inorderTraversal(root.left, traversal);
        traversal.add(root.val);
        inorderTraversal(root.right, traversal);
        
        return;
        
    }
    
}

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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();
        
        postOrder(root, answer);
        
        return answer;
        
    }
    
    private void postOrder(TreeNode root, List<Integer> answer){
        
        if(root == null){
            return;
        }
        
        postOrder(root.left, answer);
        postOrder(root.right, answer);
        answer.add(root.val);
        
        return;
        
    }
    
}

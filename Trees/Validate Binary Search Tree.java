class Solution {
    public boolean isValidBST(TreeNode root) {
        
        long[] prev = {-9999999999L};
        
        return isBST(root, prev);
    
    }
    
    private boolean isBST(TreeNode root, long[] prev){
        
        if(root == null){
            return true;
        }
        
        boolean leftAns = isBST(root.left, prev);
        
        if(root.val <= prev[0]){
            return false;
        }
        
        prev[0] = root.val;
        
        boolean rightAns = isBST(root.right, prev);
        
        return leftAns && rightAns;
            
    }
    
}

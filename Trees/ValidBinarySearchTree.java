public class ValidBinarySearchTree { 
    public boolean isValidBST(TreeNode root) 
    {
        return validBSTcheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validBSTcheck(TreeNode root, long minValue, long maxValue){
        if (root == null) {
            return true;
        }
        if (!(minValue < root.val && root.val < maxValue)) {
            return false;
        }
        return validBSTcheck(root.left, minValue, root.val) && validBSTcheck(root.right, root.val, maxValue);
    }
}

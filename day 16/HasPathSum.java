
class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        boolean[] found = {false};
        helper(root, 0, targetSum, found);

        return found[0];
    }

    private void helper(TreeNode root, int sum, int targetSum, boolean[] found){
        // base case
        if (root == null){
            return;
        }

         // pre-Order
        sum += root.val;

        // leaf node
        if (root.left == null && root.right == null){
            if (sum == targetSum){
                found[0] = true;
            }
        }

        helper(root.left, sum, targetSum, found);
        helper(root.right, sum, targetSum, found);
        sum -= root.val;
    }
}
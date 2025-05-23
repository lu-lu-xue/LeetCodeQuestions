class SumOfLeftLeaves{
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] sum = {0};
        helper(root, sum);
        return sum[0];
    }

    private void helper(TreeNode root, int[] sum){
        if (root == null){
            return;
        }

        // pre-order
        if (root.left != null && root.left.left == null && root.left.right == null){
            sum[0] += root.left.val;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }
}
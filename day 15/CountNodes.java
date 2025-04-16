class countNodes {
    public int countNodes(TreeNode root) {
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

        sum[0]++;
        helper(root.left,sum);
        helper(root.right, sum);
    }
}
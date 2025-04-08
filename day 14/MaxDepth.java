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
class MaxDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        
        if (root == null){
            return 0;
        }

        int[] depth = {0};

        helper(root, depth, 0);

        return depth[0];
    }

    private void helper(TreeNode root, int[] depth, int n){
        if (root == null){
            depth[0] = Math.max(depth[0], n);
            return;
        }

        helper(root.left, depth, n+1);
        helper(root.right, depth, n+1);
    }
}
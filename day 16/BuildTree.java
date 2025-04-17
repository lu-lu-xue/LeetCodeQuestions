import java.util.Map;
import java.util.HashMap;

class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null){
            return null;
        }

        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, n - 1, postorder, 0, n-1, map);
    }

    private TreeNode helper(int[] in, int inLeft, int inRight, int[] post, int postLeft, int postRight, Map<Integer, Integer> map){
        // base case
        if (inLeft > inRight){
            return null;
        }

        // value for root
        int valueOfroot = post[postRight];

        // locate the position in inorder
        int pos = map.get(valueOfroot);

        // pre-Order
        // construct the node
        TreeNode root = new TreeNode(valueOfroot);
        // size of left and right
        int leftSize = pos - inLeft;

        // split into two parts
        root.left = helper(in, inLeft, pos - 1, post, postLeft, postLeft + leftSize - 1, map);
        root.right = helper(in, pos + 1, inRight, post, postLeft + leftSize, postRight - 1, map);

        return root;
    }
}
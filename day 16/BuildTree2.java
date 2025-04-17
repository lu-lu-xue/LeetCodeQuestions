
import java.util.Map;
import java.util.HashMap;

class BuildTree2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        // base case
        if (preLeft > preRight) {
            return null;
        }

        // get the root
        int valueOfRoot = preorder[preLeft];
        // pos in inorder
        int pos = map.get(valueOfRoot);
        int leftSize = pos - inLeft;

        TreeNode root = new TreeNode(valueOfRoot);
        root.left = helper(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, pos - 1, map);
        root.right = helper(preorder, preLeft + leftSize + 1, preRight, inorder, pos + 1, inRight, map);

        return root;
    }
}

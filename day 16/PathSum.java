import java.util.List;
import java.util.ArrayList;

class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        List<Integer> path = new ArrayList<>();
        helper(root, 0, targetSum, path, res);

        return res;        
    }

    private void helper(TreeNode root, int sum, int target, List<Integer> path, List<List<Integer>> res){
        // base case
        if (root == null){
            return;
        }

        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == target){
                // // wrong copy!!!
                // res.add(path);
                res.add(new ArrayList<>(path));
            }
        }

        helper(root.left, sum, target, path, res);
        helper(root.right, sum, target, path, res);

        sum -= root.val;
        path.remove(path.size() - 1);
    }
}
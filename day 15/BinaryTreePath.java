import java.util.ArrayList;
import java.util.List;

class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
		if (root == null){
			return null;
		}
		
		List<String> res = new ArrayList<>();
		// sb: elements on the path
		List<String> path = new ArrayList<>();
		helper(root, res, path);
		
		return res;
	}
	
	private static void helper(TreeNode root, List<String> res, List<String> path){
		if (root == null){
			return;
		}
		
		// collect the answer
		if (root.left == null && root.right == null){
			// int value + "" (empty String) -> String
			path.add(root.val + "");
			// insert -> in between numbers
			StringBuilder sb = new StringBuilder();
			// concatenate the n-1 elements
			// a->b->
			for (int i = 0; i < path.size() - 1; i++){
				sb.append(path.get(i)).append("->");
			}
			// handle the last element
			sb.append(path.get(path.size() - 1));
			res.add(sb.toString());
			path.remove(path.size() - 1);
			return;
		}
		
		// root node
		path.add(root.val + "");
		// left child
		helper(root.left, res, path);
		helper(root.right, res, path);
		// right child
		path.remove(path.size() - 1);
	}
}
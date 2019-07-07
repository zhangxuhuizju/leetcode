public class Problem112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }
    private boolean dfs(TreeNode root, int sum, int target) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null && sum == target)
            return true;
        else return dfs(root.left, sum, target) || dfs(root.right, sum, target);
    }
}

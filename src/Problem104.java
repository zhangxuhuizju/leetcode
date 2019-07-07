public class Problem104 {
    int res = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        res = Math.max(res, depth);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}

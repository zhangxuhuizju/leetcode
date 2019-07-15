public class Problem129 {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    void dfs(TreeNode root, int value) {
        if (root == null)
            return;
        value = value * 10 + root.val;
        if (root.left == null && root.right == null)
            res += value;
        dfs (root.left, value);
        dfs (root.right, value);
    }
}

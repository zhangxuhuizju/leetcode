public class Problem99 {
    TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null)
                first = pre;
            second = root;
        }
        pre = root;
        inOrder(root.right);
    }
}

public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int lh = getHeight(root.left), rh = getHeight(root.right);
        return Math.abs(lh-rh) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(getHeight(root.right), getHeight(root.left));
    }
}

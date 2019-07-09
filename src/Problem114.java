public class Problem114 {
    public void flatten(TreeNode root) {
        TreeNode index = root;
        while (index != null) {
            if (index.left != null) {
                TreeNode temp = index.left;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = index.right;
                index.right = index.left;
                index.left = null;
            }
            index = index.right;
        }
    }
}

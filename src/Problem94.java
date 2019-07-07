import java.util.ArrayList;
import java.util.List;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null)
            inOrder(root.left, res);
        res.add(root.val);
        if (root.right != null)
            inOrder(root.right, res);
    }
}

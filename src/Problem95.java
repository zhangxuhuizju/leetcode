import java.util.ArrayList;
import java.util.List;

public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int begin, int end) {
        List<TreeNode> res = new ArrayList<>();
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        if (begin > end) {
            res.add(null);
            return res;
        }
        for (int i = begin; i <= end; ++i) {
            left = generate(begin, i - 1);
            right = generate(i + 1, end);
            for (TreeNode l : left)
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
        }
        return res;
    }
}

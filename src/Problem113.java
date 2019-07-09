import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum, int target) {
        if (root == null) return;
        sum += root.val;
        list.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs (root.left, sum, target);
        dfs (root.right, sum, target);
        list.remove(list.size()-1);
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- != 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null)
                    return depth;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return depth;
    }
}

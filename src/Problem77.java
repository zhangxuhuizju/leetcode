import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs (1, n, k);
        return res;
    }
    private void dfs(int index, int n, int k) {
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        } else if (n - index + list.size() + 1 < k)
            return;
        list.add(index);
        dfs(index + 1, n, k);
        list.removeLast();
        dfs(index + 1, n, k);
    }
}

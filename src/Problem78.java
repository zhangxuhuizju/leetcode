import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs (0, nums);
        return res;
    }
    private void dfs(int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs (index+1, nums);
        list.removeLast();
        dfs (index+1, nums);
    }
}

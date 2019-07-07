import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) return result;
        dfs(candidates, 0, 0, target);
        return result;
    }

    private void dfs(int[] nums, int index, int sum, int target) {
        if (sum >= target) {
            if(sum == target) result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            list.addLast(nums[i]);
            dfs (nums, i, sum+nums[i], target);
            list.pollLast();
        }
    }
}

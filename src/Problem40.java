import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem40 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) return result;
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target);
        return result;
    }

    private void dfs(int[] nums, int index, int sum, int target) {
        if (sum >= target) {
            if(sum == target) result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i-1]) continue;
            list.addLast(nums[i]);
            dfs (nums, i + 1, sum+nums[i], target);
            list.pollLast();
        }
    }
}

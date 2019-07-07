import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs (0, nums);
        return res;
    }

    private void dfs(int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            dfs (i + 1, nums);
            list.remove(list.size()-1);
        }
    }
}

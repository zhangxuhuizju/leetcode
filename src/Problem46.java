import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return res;
    }

    private void permute(int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i-1]) continue;
            swap (nums, start, i);
            list.add(nums[start]);
            permute(nums, start + 1);
            swap (nums, start, i);
            list.pollLast();
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

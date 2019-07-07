import java.util.Arrays;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target)
                    return target;
                else {
                    if (Math.abs(nums[i] + nums[left] + nums[right] - target)
                            < Math.abs(target - res))
                        res = nums[i] + nums[left] + nums[right];
                    if (nums[i] + nums[left] + nums[right] > target)
                        right--;
                    else left++;
                }
            }
        }
        return res;
    }
}

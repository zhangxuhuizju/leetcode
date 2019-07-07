public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int left = 0, right = nums.length - 1;
        boolean find = false;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target)
                find = true;
            if (nums[middle] >= target)
                right = middle - 1;
            else left = middle + 1;
        }
        if (!find) return res;
        res[0] = left;
        left = 0; right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target)
                right = middle - 1;
            else left = middle + 1;
        }
        res[1] = right;
        return res;
    }
}

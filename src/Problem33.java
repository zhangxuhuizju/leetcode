public class Problem33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target)
                return middle;
            else if ((nums[right] >= nums[middle] && nums[middle] < target && nums[right] >= target) ||
                    (nums[left] <= nums[middle] && (target < nums[left] || target >nums[middle])))
                left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}

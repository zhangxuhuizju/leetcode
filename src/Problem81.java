public class Problem81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target)
                return true;
            if (nums[left] == nums[middle] && nums[right] == nums[middle]) {
                left++;
                right--;
            } else if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle])
                    right = middle - 1;
                else left = middle + 1;
            } else {
                if (nums[middle] < target && target <= nums[right])
                    left = middle + 1;
                else right = middle - 1;
            }
        }
        return false;
    }
}

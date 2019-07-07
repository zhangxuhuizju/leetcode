public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length < 1) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] < target)
                left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
}

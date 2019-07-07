public class Problem41 {
    //思路上就是第i个位置放i+1，然后遍历找到答案。但是里面的细节需要注意！！！
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //！！！注意这里的while循环
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        int i = 0;
        while (i < n && i + 1 == nums[i]) i++;
        return i + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] a = {5, 4, 1, 3, 2};
        new Problem41().firstMissingPositive(a);
    }
}

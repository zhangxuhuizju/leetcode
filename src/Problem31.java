import java.util.Arrays;

public class Problem31 {
    /*
        本题用O(n) 的方法比较巧妙，从后往前扫描，遇到第一个非递增的数字，
        与后面序列中第一个大于它的数字交换，然后将后面序列逆序即可
     */
    public void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length-2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if (index == -1) reverse(nums, 0, nums.length - 1);
        else {
            for (int i = nums.length - 1; i > index; -- i) {
                if (nums[i] > nums[index]) {
                    exchange(nums, i, index);
                    break;
                }
            }
            reverse(nums, index + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            exchange(nums, start++, end--);
        }
    }

    private void exchange(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

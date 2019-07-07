/**
 *  快速排序pivot的一个典型应用
 */
public class Problem75 {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        int index = 0;
        while (index <= two) {
            if (nums[index] == 0) {
                swap(nums, index, zero);
                zero++;
                index++;
            } else if (nums[index] == 1)
                index++;
            else {
                swap(nums, index, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

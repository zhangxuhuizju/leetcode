public class Problem80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2, pre = nums[0];
        for (int i = 2; i < nums.length; ++i)
            if (nums[i] == pre)
                continue;
            else {
                pre = nums[i-1];
                nums[index++] = nums[i];
            }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        new Problem80().removeDuplicates(a);
    }
}

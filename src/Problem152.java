public class Problem152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int neg = 0, pos = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            int preNeg = neg;
            int prePos = pos;
            neg = Math.min(num, Math.min(preNeg*num, prePos*num));
            pos = Math.max(num, Math.max(preNeg*num, prePos*num));
            res = Math.max(res, pos);
        }
        return res;
    }
}

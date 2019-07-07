/*
简单题，暴力法或者用哈希记录位置然后排序求解
简单起见暴力法直接上
 */
public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i)
            for (int j = 1+i; j < nums.length; ++j)
                if (nums[i] + nums[j] == target) {
                    int[] res = new int[2];
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
        return null;
    }
}

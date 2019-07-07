/*
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length - 1) {
            end = Math.max(end, nums[start] + start);
            start++;
        }
        return end >= nums.length-1;
    }
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int maxEnd = 0, start = 0, end = 0;
        while (start < nums.length - 1) {
            if (start > end ||(start == end && nums[start] == 0))
                return false;
            for (int i = start; i <= end; ++i) {
                maxEnd = Math.max(maxEnd, i + nums[i]);
                if (maxEnd >= nums.length - 1)
                    return true;
            }
            start = end + 1;
            end = maxEnd;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,0,2,1,2,1,0};
        new Problem55().canJump(a);
    }
}

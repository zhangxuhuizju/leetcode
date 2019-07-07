public class Problem45 {
    /*
        思路，每次for里面遍历第一步能到的位置，第二步能到的位置等
     */
    public int jump(int[] nums) {
        int steps = 0;
        int start = 0, end = 0;
        int maxEnd = 0;
        while (maxEnd < nums.length-1) {
            for (int i = start; i <= end; ++i) {
                maxEnd = Math.max(maxEnd, i+nums[i]);
            }
            start = end + 1;
            end = maxEnd;
            steps++;
        }
        return steps;
    }
}

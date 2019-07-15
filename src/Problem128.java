import java.util.*;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums)
            set.add(num);
        int count = 0, res = 0, pre = Integer.MAX_VALUE;
        for (int num : set) {
            if (num == pre + 1)
                count++;
            else count = 1;
            pre = num;
            res = Math.max(res, count);
        }
        return res;
    }
}

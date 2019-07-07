import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int left = intervals[0][0], right = intervals[0][1];
        int index = 1;
        while (index < intervals.length) {
            if (intervals[index][0] > right) {
                res.add(new int[]{left, right});
                left = intervals[index][0];
                right = intervals[index][1];
            } else {
                right = Math.max(right, intervals[index][1]);
            }
        }
        res.add(new int[]{left, right});
        //toArray会自动转化为数组，第一个元素代表了这个数组里面至少含有多少个元素
        return res.toArray(new int[0][]);
    }
}

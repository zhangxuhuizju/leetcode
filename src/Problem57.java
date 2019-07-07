import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans1 = new ArrayList<int[]>();//start之前
        List<int[]> ans2 = new ArrayList<int[]>();//end之后
        int start = 0, end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                ans1.add(intervals[i]);
            } else {
                start = i;
                break;
            }
        }
        for (int i = intervals.length - 1; i >= start; i--) {
            if (intervals[i][0] > newInterval[1]) {
                ans2.add(intervals[i]);
            } else {
                end = i;
                break;
            }
        }
        int[] mid = new int[2];
        if (intervals.length == 0 || intervals[start][1] < newInterval[0] || intervals[end][0] > newInterval[1]) {
            //如果被插入集为空 或者 插入数组应该插在两端（这时初始化的start end值（0）是错误的值）
            mid[0] = newInterval[0];
            mid[1] = newInterval[1];
        } else {
            mid[0] = Math.min(intervals[start][0], newInterval[0]);
            mid[1] = Math.max(intervals[end][1], newInterval[1]);
        }
        ans1.add(mid);
        Collections.reverse(ans2);//注意ans2需要反序
        ans1.addAll(ans2);
        return ans1.toArray(new int[0][]);
    }
}

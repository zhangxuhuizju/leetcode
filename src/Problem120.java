import java.util.List;

public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        for (int i = rowNum - 2; i >= 0; --i) {
            List<Integer> list = triangle.get(i);
            List<Integer> last = triangle.get(i+1);
            for (int j = 0; j < list.size(); ++j)
                list.set(j, Math.min(last.get(j), last.get(j+1))+list.get(j));
        }
        return triangle.get(0).get(0);
    }
}

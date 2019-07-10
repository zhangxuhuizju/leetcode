import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) list.add(1);
            else {
                List<Integer> last = res.get(res.size() - 1);
                int lastNum = 0;
                for (int num : last) {
                    list.add(lastNum + num);
                    lastNum = num;
                }
                list.add(lastNum);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}

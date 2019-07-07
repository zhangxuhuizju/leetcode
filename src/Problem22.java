import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    List<String> res = new ArrayList();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        dfs (n, 0, 0);
        return res;
    }
    private void dfs(int n, int leftNum, int rightNum) {
        if (n == leftNum && n == rightNum) {
            res.add(sb.toString());
            return;
        }
        if (leftNum < n) {
            sb.append('(');
            dfs(n, leftNum+1, rightNum);
            sb.deleteCharAt(sb.length()-1);
        }
        if (rightNum < leftNum) {
            sb.append(')');
            dfs(n, leftNum, rightNum+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

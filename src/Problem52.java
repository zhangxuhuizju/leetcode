import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem52 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] queue = new char[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                queue[i][j] = '.';
        dfs(0, n, queue, res);
        return res;
    }

    private void dfs(int k, int n, char[][] queue, List<List<String>> res) {
        if (k == n) {
            String[] s = new String[n];
            for (int i = 0; i != n; ++i)
                s[i] = String.valueOf(queue[i]);
            res.add(Arrays.asList(s));
            return;
        }

        for (int i = 0; i < n; ++i) {
            queue[k][i] = 'Q';
            if (valid(queue, k, i)) dfs(k + 1, n, queue, res);
            queue[k][i] = '.';
        }

    }

    public static boolean valid(char[][] queue, int k, int index) {
        int n = queue.length;
        for (int i = 0; i < k; ++i)
            if (queue[i][index] == 'Q'
                    || (index+i-k >= 0 && queue[i][index+i-k] == 'Q')
                    || (index+k-i < n && queue[i][index+k-i] == 'Q'))
                return false;
            return true;
    }

    public static void main(String[] args) {
        new Problem52().solveNQueens(4);
    }
}

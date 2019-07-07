public class Problem51 {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] queue = new char[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                queue[i][j] = '.';
        dfs(0, n, queue);
        return count;
    }

    private void dfs(int k, int n, char[][] queue) {
        if (k == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; ++i) {
            queue[k][i] = 'Q';
            if (Problem52.valid(queue, k, i)) dfs(k + 1, n, queue);
            queue[k][i] = '.';
        }
    }

}

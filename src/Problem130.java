public class Problem130 {
    int row, col;
    boolean[][] meet = null;
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) return;
        row = board.length;
        col = board[0].length;
        meet = new boolean[row][col];
        for (int i = 0; i != col; ++i) {
            if (board[0][i] == 'O' && !meet[0][i])
                dfs (0, i, board);
            if (board[row-1][i] == 'O' && !meet[row-1][i])
                dfs (row-1, i, board);
        }
        for (int i = 0; i != row; ++i) {
            if (board[i][0] == 'O' && !meet[i][0])
                dfs (i, 0, board);
            if (board[i][col-1] == 'O' && !meet[i][col-1])
                dfs (i, col-1, board);
        }

        for (int i = 0; i != row; ++i)
            for (int j = 0; j != col; ++j)
                if (!meet[i][j]) board[i][j] = 'X';
    }

    void dfs (int r, int c, char[][] board) {
        meet[r][c] = true;
        if (r-1 >= 0 && board[r-1][c] == 'O' && !meet[r-1][c])
            dfs(r-1, c, board);
        if (r+1 < row && board[r+1][c] == 'O' && !meet[r+1][c])
            dfs(r+1, c, board);
        if (c - 1 >= 0 && board[r][c-1] == 'O' && !meet[r][c-1])
            dfs(r, c - 1, board);
        if (c + 1 < col && board[r][c + 1] == 'O' && !meet[r][c + 1])
            dfs(r, c + 1, board);
    }
}
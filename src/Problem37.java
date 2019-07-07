public class Problem37 {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public boolean dfs (char[][] board, int i, int j) {
        if (i == 9) return true;
        else if (j == 9) return dfs(board, i + 1, 0);
        else if (board[i][j] != '.') return dfs(board, i, j + 1);
        else {
            for (int k = 1; k <= 9; ++k) {
                board[i][j] = (char)(k + '0');
                if (isValid(board, i, j) && dfs(board, i, j + 1))
                    return true;
                else board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; ++k) {
            if (k != i && board[k][j] == board[i][j]) return false;
            if (k != j && board[i][k] == board[i][j]) return false;
        }
        for (int row = i/3*3; row < i/3*3+3; ++row)
            for (int col = j/3*3; col < j/3*3+3; ++col) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        return true;
    }
}

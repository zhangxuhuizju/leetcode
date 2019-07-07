public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            if (!isValid(board, i, i + 1, 0, 9)) return false;
            if (!isValid(board, 0, 9, i, i + 1)) return false;
        }
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (!isValid(board, i*3, (i + 1) * 3, j*3, (j + 1) * 3)) return false;
        return true;
    }

    private boolean isValid(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        boolean[] meet = new boolean[10];
        for (int i = rowStart; i < rowEnd; ++i)
            for (int j = colStart; j < colEnd; ++j) {
                if (board[i][j] == '.') continue;
                else if (meet[board[i][j] - '0']) return false;
                else meet[board[i][j] - '0'] = true;
            }
        return true;
    }
}

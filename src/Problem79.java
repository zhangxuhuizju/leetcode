public class Problem79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j] &&
                        dfs(i, j, 0, word, visited, board)) return true;
            }
        }
        return false;
    }

    private boolean dfs (int row, int col, int index ,String word, boolean[][] visited, char[][] board) {
        if (index == word.length()) return true;
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(index) || visited[row][col])
            return false;
        visited[row][col] = true;
        if (dfs(row+1, col, index+1, word, visited, board) || dfs(row-1, col,index+1, word, visited, board) || dfs(row, col+1,  index+1, word, visited, board) || dfs(row, col-1, index+1, word, visited, board))
            return true;
        visited[row][col] = false; // 回溯
        return false;
    }
}

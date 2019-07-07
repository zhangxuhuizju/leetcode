public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row - 1, rowNum = 0, colNum = 0;
        while (left <= right) {
            rowNum = (left + right) / 2;
            if (target >= matrix[rowNum][0] && target <= matrix[rowNum][col-1])
                break;
            else if (target > matrix[rowNum][col-1])
                left = rowNum + 1;
            else right = rowNum - 1;
        }
        if (left > right) return false;
        left = 0;
        right = row - 1;
        while (left <= right) {
            colNum = (left + right) / 2;
            if (target == matrix[rowNum][colNum])
                return true;
            else if (target > matrix[rowNum][colNum])
                right = colNum - 1;
            else left = colNum + 1;
        }
        return false;
    }
}

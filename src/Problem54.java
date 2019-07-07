import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int row1 = 0, row2 = matrix.length, col1 = 0, col2 = matrix[0].length;
        int count = row2 * col2;
        while (true) {
            for (int i = col1; i < col2; ++i)
                result.add(matrix[row1][i]);
            for (int i = row1 + 1; i < row2; ++i)
                result.add(matrix[i][col2 - 1]);
            if (result.size() == count) break;
            for (int i = col2 - 2; i >= col1; --i)
                result.add(matrix[row2 - 1][i]);
            for (int i = row2 - 2; i >= row1 + 1; --i)
                result.add(matrix[i][col1]);
            if (result.size() == count) break;
            row1++;
            col1++;
            row2--;
            col2--;
        }
        return result;
    }
}

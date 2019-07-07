public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] numbers = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                if (matrix[i][j] == '1') numbers[j]++;
                else numbers[j] = 0;
            res = new Problem84().largestRectangleArea(numbers);
        }
        return res;
    }
}

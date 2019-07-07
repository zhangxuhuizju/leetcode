public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = n * n;
        int index1 = 0, index2 = n, count = 0;
        while (index1 < index2) {
            for (int i = index1; i < index2; ++i)
                res[index1][i] = ++count;
            for (int i = index1 + 1; i < index2; ++i)
                res[i][index2-1] = ++count;
            if (count == num)
                break;
            for (int i = index2 - 2; i >= index1; --i)
                res[index2-1][i] = ++count;
            for (int i = index2 - 2; i >= index1 + 1; --i)
                res[i][index1] = ++count;
            index1++;
            index2--;
        }
        return res;
    }
}

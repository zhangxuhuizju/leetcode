public class Problem70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2, res = 3, index = 3;
        while (index++ < n) {
            int temp = res + b;
            a = b;
            b = res;
            res = temp;
        }
        return res;
    }
}

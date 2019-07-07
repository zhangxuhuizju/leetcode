public class Problem7 {
    public int reverse(int x) {
        long res = 0;
        boolean isNegative = false;
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (isNegative) res = -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        else return (int)res;
    }
}

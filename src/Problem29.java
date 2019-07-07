import org.omg.PortableInterceptor.INACTIVE;

public class Problem29 {
    public int divide(int dividend, int divisor) {
        long res = 0;
        boolean negative = (dividend ^ divisor) < 0;
        long dividend_ = Math.abs((long)dividend), divisor_ = Math.abs((long)divisor);
        long temp = divisor_;
        int count = 1;
        while (dividend_ >= divisor_) {
            dividend_ -= temp;
            res += count;
            count <<= 1;
            temp <<= 1;
            if (dividend_ < temp) {
                temp = divisor_;
                count = 1;
            }
        }
        if (negative) res = -res;
        if(res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE)
            return (int)res;
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
       new Problem29().divide(-2147483648, -1);
    }
}

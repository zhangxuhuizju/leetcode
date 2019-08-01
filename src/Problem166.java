import java.util.*;

public class Problem166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num1 = numerator;
        long num2 = denominator;
        StringBuilder sb = new StringBuilder();
        if (num1 < 0 ^ num2 < 0 && num1 != 0)
            sb.append('-');
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        sb.append(num1 / num2);
        long remain = num1 % num2;
        if (remain > 0)
            sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (remain != 0) {
            if (map.containsKey(remain)) {
                sb.insert(map.get(remain), "(");
                sb.append(')');
                break;
            }
            map.put(remain, sb.length());
            sb.append(remain*10/num2);
            remain = remain*10%num2;
        }
        return sb.toString();
    }
}

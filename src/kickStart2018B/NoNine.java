package kickStart2018B;

import java.util.*;
import java.io.*;

public class NoNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int k = 1; k <= T; ++k) {
            System.out.print("Case #" + k + ": ");
            String num1 = in.next(), num2 = in.next();
            System.out.println(calNum(num2) - calNum(num1) + 1);
        }
    }

    private static long calNum(String number) {
        long num = Long.valueOf(number);
        long temp = num / 10 * 10;
        int count = 0;
        for (; temp <= num; ++temp)
            if (temp % 9 != 0)
                count++;
        num = num / 10 * 10;
        long numBase9 = 0, index = 1;
        while (num != 0) {
            temp = num % 10;
            num /= 10;
            numBase9 += index * temp;
            index *= 9;
        }
        return numBase9 * 8 / 9 + count;
    }
}

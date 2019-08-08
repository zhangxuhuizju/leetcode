package kickStart2018A;

import java.util.*;
import java.io.*;

public class EvenDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print("Case #" + i + ": ");
            int index = -1;
            String number = String.valueOf(in.nextLong());
            char[] digits = number.toCharArray();
            for (int k = 0; k < digits.length; ++k) {
                if ((digits[k] - '0') % 2 == 1) {
                    index = k;
                    break;
                }
            }
            if (index == -1) {
                System.out.println(0);
                continue;
            }
            char[] lower = Arrays.copyOf(digits, digits.length);
            lower[index]--;
            for (int k = index + 1; k < digits.length; ++k)
                lower[k] = '8';
            long lowNumber = Long.valueOf(String.valueOf(lower));
            char[] upper = Arrays.copyOf(digits, digits.length);
            for (int k = index + 1; k < digits.length; ++k)
                upper[k] = '0';
            long uppNumber = 0;
            if (upper[index] != '9')
                upper[index]++;
            else {
                upper[index] = '0';
                for (--index; index >= 0; --index) {
                    if (upper[index] != '8') {
                        upper[index] += 2;
                        break;
                    } else {
                        upper[index] = '0';
                    }
                }
            }
            if (index < 0) {
                uppNumber = Long.valueOf("2" + String.valueOf(upper));
            } else uppNumber = Long.valueOf(String.valueOf(upper));
            Long res = Math.min(Long.valueOf(number) - lowNumber, uppNumber - Long.valueOf(number));
            System.out.println(res);
        }
    }
}

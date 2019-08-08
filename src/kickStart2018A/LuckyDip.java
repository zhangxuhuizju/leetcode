package kickStart2018A;

import java.util.*;
import java.io.*;

public class LuckyDip {
    private static double calAverage(int[] number, double cmp) {
        double sum = 0;
        for (int i = 0; i < number.length; ++i)
            sum += Math.max(number[i], cmp);
        return sum/(number.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int k = 1; k <= T; ++k) {
            int N = in.nextInt(), K = in.nextInt();
            int[] number = new int[N];
            for (int i = 0; i < N; ++i)
                number[i] = in.nextInt();
            Arrays.sort(number);
            double res = calAverage(number, -1);
            while (K-- > 0) {
                res = calAverage(number, res);
            }
            System.out.print("Case #" + k + ": ");
            System.out.format("%.6f", res);
            System.out.println();
        }
    }
}

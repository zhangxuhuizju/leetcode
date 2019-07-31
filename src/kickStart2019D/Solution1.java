package kickStart2019D;

import java.util.*;
import java.io.*;

public class Solution1 {
    private static boolean isEven(int num) {
        String s = Integer.toBinaryString(num);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }
        return count % 2 == 0;
    }

    private static int findLongest(boolean[] even) {
        int res = 0, left = -1, right = even.length, count = 0;
        for (int i = 0; i < even.length; ++i) {
            if (!even[i]) {
                count++;
                if (left == -1)
                    left = right;
            }
        }
        for (int i = even.length - 1; i >= 0; --i) {
            if (!even[i]) {
                right = i;
                break;
            }
        }
        if (count % 2 == 0)
            return even.length;
        return Math.max(even.length - left - 1, right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= T; ++k) {
            int N = in.nextInt();
            int Q = in.nextInt();
            int[] nums = new int[N];
            boolean[] even = new boolean[N];
            int[] results = new int[Q];
            for (int i = 0; i < N; ++i) {
                nums[i] = in.nextInt();
                even[i] = isEven(nums[i]);
            }
            int res = findLongest(even);
            for (int i = 0; i < Q; ++i) {
                int index = in.nextInt();
                nums[index] = in.nextInt();
                if (isEven(nums[index]) == even[index])
                    results[i] = res;
                else {
                    even[index] = !even[index];
                    res = findLongest(even);
                    results[i] = res;
                }
            }
            System.out.print("Case #" + k + ":");
            for (int result : results)
                System.out.print(" " + result);
            System.out.println();
        }
    }
}

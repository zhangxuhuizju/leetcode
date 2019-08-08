package kickStart2018A;

import java.util.*;
import java.io.*;

public class ScrambledWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int k = 1; k <= T; ++k) {
            int L = in.nextInt();
            String[] words = new String[L];
            Set<Integer> lengthType = new HashSet<>();
            Map<String, Integer> wordsMap = new HashMap<>();
            for (int i = 0; i < L; ++i) {
                words[i] = in.next();
                lengthType.add(words[i].length());
                char[] chars = words[i].toCharArray();
                Arrays.sort(chars, 1, chars.length - 1);
                String word = String.valueOf(chars);
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
            }
            char s1 = in.next().charAt(0), s2 = in.next().charAt(0);
            int N = in.nextInt();
            long A = in.nextLong(), B = in.nextLong(), C = in.nextLong(), D = in.nextLong();
            StringBuilder sb = new StringBuilder();
            sb.append(s1).append(s2);
            long num1 = (long)(s1), num2 = (long)(s2);
            for (int i = 2; i < N; ++i) {
                long num = (num2 * A % D + num1 * B % D + C) % D;
                sb.append((char)(num % 26 + 97));
                num1 = num2;
                num2 = num;
            }
            String word = sb.toString();
            //System.out.println(sb.toString());
            int res = 0;
            for (int i = 0; i < N; ++i) {
                for (int j : lengthType) {
                    if (i + j > word.length()) continue;
                    String s = word.substring(i, i + j);
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars, 1, chars.length - 1);
                    s = String.valueOf(chars);
                    if (wordsMap.containsKey(s)) {
                        res += wordsMap.get(s);
                        wordsMap.remove(s);
                    }
                }
            }
            System.out.println("Case #" + k + ": " + res);
        }
    }
}

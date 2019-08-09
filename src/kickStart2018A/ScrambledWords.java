package kickStart2018A;

import java.util.*;
import java.io.*;

public class ScrambledWords {
    private static String changeToStr(int[] count) {
        String res = "";
        for (int num : count)
            res += num;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int k = 1; k <= T; ++k) {
            int L = in.nextInt();
            String[] words = new String[L];
            Map<Integer, Integer> lengthType = new HashMap<>();
            Map<String, Integer> wordsMap = new HashMap<>();
            for (int i = 0; i < L; ++i) {
                words[i] = in.next();
                lengthType.put(words[i].length(), lengthType.getOrDefault(words[i].length(), 0) + 1);
                int[] count = new int[28];
                for (int j = 0; j < words[i].length(); ++j) {
                    count[words[i].charAt(j)-'a']++;
                }
                count[26] = words[i].charAt(0);
                count[27] = words[i].charAt(words[i].length()-1);
                String word = changeToStr(count);
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
            for (int i : lengthType.keySet()) {
                int findNum = lengthType.get(i);
                int[] count = new int[28];
                for (int j = 0; j < word.length(); ++j) {
                    if (i + j > word.length()) break;
                    if (j == 0) {
                        for (int kk = 0; kk < i; ++kk)
                            count[word.charAt(kk)-'a']++;
                        count[26] = word.charAt(0);
                        count[27] = word.charAt(i-1);
                    } else {
                        count[word.charAt(j-1)-'a']--;
                        count[word.charAt(j+i-1)-'a']++;
                        count[26] = word.charAt(j);
                        count[27] = word.charAt(i+j-1);
                    }
                    String s = changeToStr(count);
                    if (wordsMap.containsKey(s)) {
                        res += wordsMap.get(s);
                        findNum -= wordsMap.get(s);
                        wordsMap.remove(s);
                    }
                    if (findNum == 0)
                        break;
                }
            }
            System.out.println("Case #" + k + ": " + res);
        }
    }
}

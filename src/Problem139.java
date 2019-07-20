import java.lang.reflect.Array;
import java.util.*;

public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordDictSet = new HashSet<>();
        wordDictSet.addAll(wordDict);
        for (int i = 1; i <= s.length(); ++i) {
            if (wordDictSet.contains(s.substring(0, i)))
                dp[i] = true;
        }
        for (int i = 2; i <= s.length(); ++i) {
            if (dp[i]) continue;
            for (int j = 1; j <= i; ++j) {
                dp[i] = dp[i] | (dp[j-1] & wordDictSet.contains(s.substring(j-1, i)));
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] s = {"apple", "pen"};
        new Problem139().wordBreak("applepenapple", Arrays.asList(s));
    }
}

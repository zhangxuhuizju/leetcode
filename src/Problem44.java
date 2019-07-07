public class Problem44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); ++i)
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //字符可以匹配上，那么看前面能否匹配
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                    //dp[i-1][j],表示*代表是非空字符,例如abcde,ab*
                    //dp[i][j-1],表示*代表空字符,例如ab,ab*
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

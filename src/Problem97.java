public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); ++i) {
            if (s1.charAt(i-1) != s3.charAt(i - 1))
                break;
            dp[i][0] = true;
        }
        for (int i = 1; i <= s2.length(); ++i) {
            if (s2.charAt(i-1) != s3.charAt(i - 1))
                break;
            dp[0][i] = true;
        }
        for (int i = 1; i <= s1.length(); ++i)
            for (int j = 1; j <= s2.length(); ++j)
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) ||
                        (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
        return dp[s1.length()][s2.length()];
    }
}

public class Problem72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 1; i <= word1.length(); ++i)
            dp[i][0] = i;
        for (int i = 1; i < word2.length(); ++i)
            dp[0][i] = i;
        for (int i = 1; i < word1.length(); ++i)
            for (int j = 1; j < word2.length(); ++j) {
                if (word1.charAt(i-1) == word2.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
            }
        return dp[word1.length()][word2.length()];
    }
}

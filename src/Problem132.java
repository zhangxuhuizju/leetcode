public class Problem132 {
    public int minCut(String s) {
        if (isValid(s)) return 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i] = Integer.MAX_VALUE;
            if (isValid(s.substring(0, i + 1)))
                dp[i] = 0;
            for (int j = i; j >= 1; --j) {
                if (isValid(s.substring(j, i + 1)))
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
            }
        }
        return dp[s.length()-1];
    }

    private boolean isValid(String s) {
        if (s == null || s.length() <= 1)
            return true;
        int i = 0, j = s.length() - 1;
        while (j > i) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

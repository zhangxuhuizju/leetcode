public class Problem91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); ++i) {
            int num = (s.charAt(i-1) - '0')*10 + (s.charAt(i)-'0');
            if (num <= 26)
                dp[i] = i >= 2 ? dp[i-1] + 1 + dp[i-2] + 1 : dp[i-1]+2;
            else dp[i] = dp[i-1] + 1;
        }
        return dp[s.length()-1];
    }
}

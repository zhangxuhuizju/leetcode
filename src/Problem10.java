/*
hard题，提供两个解法，一个用递归，第二个用动态规划
递归程序的处理顺序需要注意，动态规划则需要考虑清楚所有的情况
 */
public class Problem10 {
    public boolean isMatchRC(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*')
            //易错点，先判断是否firstMatch再决定要不要接下去比较！！！
            return isMatchRC(s, p.substring(2)) ||
                    (firstMatch && isMatchRC(s.substring(1), p));
        else return firstMatch && isMatchRC(s.substring(1), p.substring(1));
    }

    public boolean isMatchDP(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        if (s.length() >= 1 && p.length() >= 1)
            dp[1][1] = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        for (int j = 2; j <= pLen; ++j)
            dp[0][j] = dp[0][j-2] && p.charAt(j-1) == '*';
        for (int i = 1; i <= sLen; ++i)
            for (int j = 2; j <= pLen; ++j) {
                if (p.charAt(j-1) == '*') {
                    //等于*的时候，要么匹配0次，要么匹配了多次。若匹配了多次，那么说明少一个也可以匹配上
                    dp[i][j] = dp[i][j-2] || (dp[i-1][j] &&
                            (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'));
                }else {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
                }
            }
        return true;
    }
}

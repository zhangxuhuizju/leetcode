import java.util.Stack;

public class Problem32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
    /*
        dp解法，dp[i]表示以i结尾的最长满足要求的子串
        根据条件进行操作
     */
    public int longestValidParenthesesDP(String s) {
        if (s == null || s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i>=2 ? dp[i-2]+2 : 2);
                } else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Problem32().longestValidParentheses(")()())");
    }
}

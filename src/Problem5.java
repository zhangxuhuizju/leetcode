/*
官方题解
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String res = s.substring(0, 1);
        int len = 1;
        for (int i = 0; i != s.length(); ++i) {
            if ((s.length() - i - 1)*2 + 1 <= len)
                break;
            String temp = getPalindrome(s, i);
            if (temp.length() > len) {
                len = temp.length();
                res = temp;
            }
        }
        return res;
    }

    private String getPalindrome(String s, int center) {
        int res1 = 1, left1 = center - 1, right1 = center + 1;
        while (left1 >= 0 && right1 < s.length()
                && s.charAt(left1) == s.charAt(right1)) {
            res1 += 2;
            left1--;
            right1++;
        }
        if (s.charAt(center) == s.charAt(center+1)) {
            int res = 2, left = center - 1, right = center + 2;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                res += 2;
                left--;
                right++;
            }
            if (res > res1) {
                left1 = left;
                right1 = right;
            }
        }
        return s.substring(left1 + 1, right1);
    }
}

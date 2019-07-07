/**
 * 很好的一个题目，学习了状态机的相关例子
 * 标准的状态机图间problem65.png
 */

public class Problem65 {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean num = false, e = false, dot = false;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i)))
                num = true;
            else if (s.charAt(i) == '.') {
                if (dot || e) return false;
                dot = true;
            } else if (s.charAt(i) == 'e') {
                if (e || !num)
                    return false;
                num = false;
                e = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i > 0 && s.charAt(i-1) != 'e') return false;
            } else return false;
        }
        return num;
    }
}

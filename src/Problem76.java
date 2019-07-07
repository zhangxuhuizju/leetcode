public class Problem76 {
    public String minWindow(String s, String t) {
        int[] character = new int[256];
        int[] str = new int[256];
        for (char c : t.toCharArray())
            ++character[c];
        /**
         * found用来标记有多少个在t里面的字符已经找到
         */
        int start = 0, begin = -1, end = s.length(), found = 0, index = 0, minLen = s.length();
        for (; index < s.length(); ++index) {
            str[s.charAt(index)]++;
            //找到一个匹配字符
            if (str[s.charAt(index)] <= character[s.charAt(index)])
                found++;
            if (found == t.length()) {
                while (start < index && str[s.charAt(start)] > character[s.charAt(start)]) {
                    str[s.charAt(start++)]--;
                }
                if (index - start < minLen) {
                    minLen = index - start;
                    end = index;
                    begin = start;
                }
                str[s.charAt(start++)]--;
                found--;
            }
        }
        return begin == -1 ? "" : s.substring(begin, end+1);
    }
}

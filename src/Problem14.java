public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String res = strs[0];
        for (String s : strs) {
            while (s.indexOf(res) != 0) {
                res = res.substring(0, res.length()-1);
                if (res.equals(""))
                    return "";
            }
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    List<String> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() > 12 || s.length() < 4) return res;
        dfs (0, s);
        return res;
    }

    private void dfs(int index, String s) {
        if (list.size() > 4) return;
        if (s.length()-index > (4-list.size())*3 || s.length()-index < (4-list.size()))
            return;
        if (index == s.length() && list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String ss : list) {
                sb.append(ss).append('.');
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); ++i) {
            if (Integer.valueOf(s.substring(index, i)) > 255)
                continue;
            if (s.charAt(index) == '0' && i - index > 1)
                continue;
            list.add(s.substring(index, i));
            dfs(i, s);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        new Problem93().restoreIpAddresses("25525511135");
    }
}

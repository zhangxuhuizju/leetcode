import java.util.*;

public class Problem131 {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return res;
        dfs(s, 0, 0);
        return res;
    }
    private void dfs(String s, int last, int now) {
        if (last == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        } else if (now >= s.length())
            return;
        if (isValid(s.substring(last, now+1))) {
            list.add(s.substring(last, now + 1));
            dfs(s, now + 1, now + 1);
            list.remove(list.size()-1);
        }
        dfs (s, last, now + 1);
    }
    private boolean isValid(String s) {
        int i = 0, j = s.length() - 1;
        while (j > i) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

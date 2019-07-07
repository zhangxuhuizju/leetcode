import java.util.*;

public class Problem17 {
    String[] word = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) return res;
        DFS (digits, 0);
        return res;
    }
    private void DFS(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < word[num].length(); ++i) {
            sb.append(word[num].charAt(i));
            DFS (digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

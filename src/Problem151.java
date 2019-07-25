public class Problem151 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        s = s.trim();
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; --i) {
            if (words[i].length() == 0) continue;
            if (words[i].charAt(0) == ' ')
                continue;
            sb.append(words[i]).append(" ");
        }
        if (sb.length() == 0) return "";
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Problem151().reverseWords("s  a b");
    }
}

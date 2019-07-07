public class Problem58 {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s+");
        if (words == null || words.length == 0)
            return 0;
        else return words[words.length-1].length();
    }
}

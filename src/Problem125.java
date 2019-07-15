public class Problem125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) return true;
        StringBuilder sb = new StringBuilder();
        sb.append(s.replaceAll("[^0-9a-zA-Z]","").toLowerCase());
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Problem125().isPalindrome("race a car"));
    }
}

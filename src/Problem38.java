public class Problem38 {
    public String countAndSay(int n) {
        String res = "1";
        while (--n > 0) {
            res = readNum(res);
        }
        return res;
    }

    private String readNum(String number) {
        number = number + ".";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = number.charAt(0);
        for (int i = 1; i < number.length(); ++i) {
            if (number.charAt(i) == number.charAt(i-1))
                count++;
            else {
                sb.append(count).append(c);
                c = number.charAt(i);
                count = 1;
            }
        }
        return sb.toString();
    }
}

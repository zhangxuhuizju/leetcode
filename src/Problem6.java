public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i != numRows; ++i)
            sb[i] = new StringBuilder();
        int add = 1, temp = 0;
        for (char c : s.toCharArray()) {
            sb[temp].append(c);
            temp += add;
            if (temp == numRows) {
                temp -= 2;
                add = -1;
            } else if (temp == -1) {
                temp += 2;
                add = 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder ss : sb) {
            res.append(ss);
        }
        return res.toString();
    }
}

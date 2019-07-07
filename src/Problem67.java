public class Problem67 {
    public String addBinary(String a, String b) {
        if (a.length() < b.length())
            return addBinary(b, a);
        StringBuilder sb = new StringBuilder();
        int add = 0;
        int index1 = a.length() - 1, index2 = b.length() - 1;
        for (; index1 >= 0; --index1, --index2) {
            int num = a.charAt(index1) - '0' + add;
            if (index2 >= 0)
                num += b.charAt(index2) - '0';
            add = num / 2;
            sb.append(num % 2);
        }
        if (add == 1)
            sb.append(add);
        return sb.reverse().toString();
    }
}

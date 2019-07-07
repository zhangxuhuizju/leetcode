import sun.dc.pr.PRError;

public class Problem43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; --i) {
            StringBuilder sb = new StringBuilder();
            sb.append(multiply(num1, num2.charAt(i)));
            for (int j = 1; j < num2.length() - i; ++j)
                sb.append(0);
            res = add(res, sb.toString());
        }
        return res;
    }

    private String multiply(String num, char count) {
        if (count == '0') return "0";
        String res = num;
        for (int i = 1; i < count - '0'; ++i)
            res = add(res, num);
        return res;
    }

    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, index1 = num1.length() - 1, index2 = num2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            int number1 = num1.charAt(index1--) - '0';
            int number2 = num2.charAt(index2--) - '0';
            int sum = number1 + number2 + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            sb.append(sum);
        }
        while (index1 >= 0) {
            int sum = num1.charAt(index1--) - '0' + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            sb.append(sum);
        }
        while (index2 >= 0) {
            int sum = num2.charAt(index2--) - '0' + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else carry = 0;
            sb.append(sum);
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new Problem43().add("9876543120000000", "944977892635269");
    }
}

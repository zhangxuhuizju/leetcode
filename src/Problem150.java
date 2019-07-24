import java.util.LinkedList;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            int num1, num2;
            if (token.equals("+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (token.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (token.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (token.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
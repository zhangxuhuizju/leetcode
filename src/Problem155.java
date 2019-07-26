import java.util.LinkedList;

public class Problem155 {
    class MinStack {

        LinkedList<Integer> stack;

        LinkedList<Integer> minElement;

        int min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            minElement = new LinkedList<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.push(x);
            if (x < min)
                min = x;
            minElement.push(min);
        }

        public void pop() {
            stack.pop();
            minElement.pop();
            min = minElement.size() == 0 ?
                    Integer.MAX_VALUE : minElement.peekFirst();
        }

        public int top() {
            return stack.peekFirst();
        }

        public int getMin() {
            return min;
        }
    }
}

import java.util.LinkedList;

public class Problem84 {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        if (heights == null || heights.length == 0) return res;
        stack.add(0);
        int index = 1;
        while (index < heights.length) {
            if (stack.isEmpty() || heights[index] >= heights[stack.peekLast()]) stack.add(index++);
            else {
                while (!stack.isEmpty() && heights[index] < heights[stack.peekLast()]) {
                    int right = index - 1;
                    int now = stack.pollLast();
                    int left = stack.isEmpty() ? -1 : stack.peekLast();
                    res = Math.max(heights[now] * (right - left), res);
                }
            }
        }
        while (!stack.isEmpty()) {
            int right = heights.length - 1;
            int now = stack.pollLast();
            int left = stack.isEmpty() ? -1 : stack.peekLast();
            res = Math.max(heights[now] * (right - left), res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        new Problem84().largestRectangleArea(a);
    }
}


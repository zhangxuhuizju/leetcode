import java.util.*;

public class Problem149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int same = 0, y = 0, count = 0;
            map.clear();
            for (int j = i + 1; j < n; ++j) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2)
                    same++;
                else if (x1 == x2)
                    y++;
                else {
                    String slope;
                    int dy = (y1 - y2);
                    int dx = (x1 - x2);
                    if (dy == 0)
                        slope = "0";
                    else {
                        int gcd = gcd(dx, dy);
                        dx /= gcd;
                        dy /= gcd;
                        slope = dy + "/" + dx;
                    }
                    map.put(slope, map.getOrDefault(slope, 1) + 1);
                    count = Math.max(map.get(slope), count);
                }
            }
            count = Math.max(count, y);
            res = Math.max(count+same, res);
        }
        return res;
    }
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
    public static void main(String[] args) {
        int[][] points = {{0,0},{94911151,94911150},{94911152,94911151}};
        new Problem149().maxPoints(points);
    }
}

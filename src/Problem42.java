public class Problem42 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int res = 0, max = height[0], maxIndex = 0;
        for (int i = 1; i < height.length; ++i)
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        max = 0;
        for (int i = 0; i < maxIndex; ++i) {
            if (height[i] > max) {
                max = height[i];
            } else res += max - height[i];
        }
        max = 0;
        for (int i = height.length - 1; i > maxIndex; --i) {
            if (height[i] > max) {
                max = height[i];
            } else res += max - height[i];
        }
        return res;
    }
}

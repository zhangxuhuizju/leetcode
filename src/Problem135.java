public class Problem135 {
    public int candy(int[] ratings) {
        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];
        leftToRight[0] = 1;
        rightToLeft[ratings.length-1] = 1;
        for (int i = 1; i < ratings.length; ++i)
            leftToRight[i] = ratings[i] > ratings[i-1] ? leftToRight[i-1] + 1 : 1;
        for (int i = ratings.length - 2; i >= 0; --i)
            rightToLeft[i] = ratings[i] > ratings[i+1] ? rightToLeft[i+1] + 1 : 1;
        int sum = 0;
        for (int i = 0; i < ratings.length; ++i)
            sum += Math.max(leftToRight[i], rightToLeft[i]);
        return sum;
    }
}

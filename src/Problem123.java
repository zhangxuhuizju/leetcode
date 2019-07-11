public class Problem123 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        int pre = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp1[i] = Math.max(dp1[i-1], prices[i] - pre);
            if (prices[i] < pre)
                pre = prices[i];
        }
        pre = prices[prices.length-1];
        for (int i = prices.length - 2; i >= 0; --i) {
            dp2[i] = Math.max(pre - prices[i], dp2[i+1]);
            if (prices[i] > pre)
                pre = prices[i];
        }
        int res = 0;
        for (int i = 0; i < prices.length; ++i)
            res = Math.max(res, dp1[i] + dp2[i]);
        return res;
    }
}

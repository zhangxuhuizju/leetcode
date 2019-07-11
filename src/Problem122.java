public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int pre = prices[0], res = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] <= pre)
                pre = prices[i];
            else {
                res += prices[i] - pre;
                pre = prices[i];
            }
        }
        return res;
    }
}

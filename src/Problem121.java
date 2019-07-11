public class Problem121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int lowest = prices[0], res = 0;
        for (int price : prices) {
            if (price < lowest)
                lowest = price;
            else res = Math.max(res, price-lowest);
        }
        return res;
    }
}

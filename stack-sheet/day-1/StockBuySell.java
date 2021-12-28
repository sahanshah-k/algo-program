//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                int tempProfit = prices[i] - minPrice;
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
            }
        }
        return maxProfit;
    }
}

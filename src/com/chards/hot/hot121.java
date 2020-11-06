package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot121
 * @date: 2020-11-06 22:46
 * <p>
 * 121. 买卖股票的最佳时机
 */
public class hot121 {

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) min = prices[i];
			else if (prices[i] - min > max)
				max = prices[i] - min;
		}
		return max;
	}
}

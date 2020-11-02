package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot70
 * @date: 2020-11-02 17:54
 * 70. 爬楼梯
 */
public class hot70 {

	public int climbStairs(int n) {
		if (n < 3) return n;
		int a = 1, b = 2, res = 0;
		for (int i = 3; i <= n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
}

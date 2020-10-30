package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot11
 * @date: 2020-10-30 23:30
 * <p>
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class hot11 {

//	public int maxArea(int[] height) {
//		int max = 0;
//		for (int i = 0, j = height.length - 1; i < j; ) {
//			int minHeight = height[i] < height[j] ? height[i++] : height[j--];
//			int area = (j - i + 1) * minHeight;
//			max = Math.max(max, area);
//		}
//		return max;
//	}

	/**
	 * 左右夾逼
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int ans = 0, left = 0, right = height.length - 1, min = Integer.MIN_VALUE;
		while (left <= right) {
			min = height[left] < height[right] ? height[left++] : height[right--];
			ans = Math.max(ans, min * (right - left + 1));
		}
		return ans;
	}

}

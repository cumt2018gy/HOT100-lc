package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot53
 * @date: 2020-11-02 11:58
 * <p>
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class hot53 {

	public int maxSubArray(int[] nums) {
		int max = nums[0], pre = 0;
		for (int num : nums) {
			pre = Math.max(pre + num, num);  // 前几位的总和最大和当前数字大小对比
			max = Math.max(max, pre);
		}
		return max;
	}
}

package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot55
 * @date: 2020-11-02 12:03
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class hot55 {
	/**
	 * 从后往前跳
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int length = nums.length, last = length - 1;
		for (int i = length - 2; i >= 0; i--) {
			if (i + nums[i] >= last) last = i;
		}
		return last == 0;
	}
}

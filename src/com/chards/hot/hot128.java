package com.chards.hot;

import java.util.Arrays;

/**
 * @author 远 chards_
 * @FileName:hot128
 * @date: 2020-11-06 23:00
 * <p>
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */
public class hot128 {

	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) return 1;
		Arrays.sort(nums);
		int length = 0, max = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) continue;
			if (nums[i] == nums[i - 1] + 1) {
				length += 1;
				max=Math.max(max,length);
			} else {
				length = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		hot128 hot128 = new hot128();
		hot128.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6});
	}
}

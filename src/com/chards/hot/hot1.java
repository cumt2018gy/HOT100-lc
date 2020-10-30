package com.chards.hot;

import java.util.HashMap;

/**
 * @author 远 chards_
 * @FileName:hot1
 * @date: 2020-10-28 21:00
 * <p>
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class hot1 {
	HashMap map = new HashMap();

	/**
	 * 定义一个map函数  存取每一个数字对应的需要补全的数字值
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int num = target - nums[i];
			if (map.containsKey(num))
				return new int[]{i, (int) map.get(num)};
			map.put(nums[i], i);
		}
		return null;
	}
}

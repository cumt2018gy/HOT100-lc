package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot34
 * @date: 2020-11-01 20:15
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 时间复杂度必须是 O(log n) 级别。
 */
public class hot34 {
	/**
	 * 二分法
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		int find = findMid(nums, target);
		if (find == -1) return new int[]{-1, -1};
		int left = find - 1;
		int right = find + 1;
		while (left >= 0 && nums[left] == target) left--;
		while (right < nums.length && nums[right] == target) right++;
		return new int[]{left + 1, right - 1};
	}

	private int findMid(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) left = mid + 1;
			else if (nums[mid] > target) right = mid - 1;
			else return mid;
		}
		return -1;
	}
}

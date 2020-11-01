package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot33
 * @date: 2020-11-01 16:06
 * 33. 搜索旋转排序数组
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class hot33 {


	//public int search(int[] nums, int target) {
	//   for (int i = 0; i < nums.length; i++) {
	//         if (nums[i]==target)return i;
	// 	}
	// 	return -1;
	// }


	public int search(int[] nums, int target) { //logN
		int lo = 0, hi = nums.length - 1, mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
			if (nums[mid] >= nums[lo]) {
				// 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
				if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

}

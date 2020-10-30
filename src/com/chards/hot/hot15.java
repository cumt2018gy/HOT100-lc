package com.chards.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot100
 * @date: 2020-10-30 23:44
 * <p>
 * 15. 三数之和
 */
public class hot15 {

	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {   // [-1, -1, 0, 1, 2]，
			// 加速1：c为非负数，就不能满足a+b+c=0了
			if (nums[i] > 0) {
				return res;
			}
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {        //   [-1, 0, 1, 1, 2]， nums[i]=-1  left=1   right=3
				int sum = -(nums[left] + nums[right]);
				if (sum == nums[i]) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// 加速3：跳过计算过的数据，同时防止结果重复
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					// 加速3：跳过计算过的数据，同时防止结果重复
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
				}
				if (sum < nums[i]) right--;
				else left++;
			}
		}
		return res;
	}


}

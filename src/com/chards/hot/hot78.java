package com.chards.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot78
 * @date: 2020-11-03 09:31
 * <p>
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class hot78 {
	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) return res;
		dfs(0, nums, new ArrayList<Integer>());
		return res;
	}

	private void dfs(int index, int[] nums, ArrayList<Integer> list) {
		if (index == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}

		dfs(index + 1, nums, list);
		list.add(nums[index]);
		dfs(index + 1, nums, list);

		list.remove(list.size() - 1);
	}




}

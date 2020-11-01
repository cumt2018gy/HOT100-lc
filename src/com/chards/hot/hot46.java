package com.chards.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot46
 * @date: 2020-11-01 21:26
 * 46. 全排列
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class hot46 {
	List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) return lists;
		Arrays.sort(nums);
		int[] visited = new int[nums.length];
		List<Integer> list = new ArrayList<>();
		generate(0, visited, nums, list);
		return lists;
	}

	private void generate(int start, int[] visited, int[] nums, List<Integer> list) {
		if (list.size() == nums.length) {
			lists.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (visited[i] == 1 ) continue;
			visited[i] = 1;
			list.add(nums[i]);
			generate(start,visited, nums, list);
			visited[i] = 0;
			list.remove(list.size() - 1);
		}
	}

}

package com.chards.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot39
 * @date: 2020-11-01 20:48
 * 39. 组合总和
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 */
public class hot39 {
	private List<List<Integer>> lists = new ArrayList<>();
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			if (candidates == null || candidates.length == 0 || target < 0) return lists;
			List<Integer> list = new ArrayList<>();
			Arrays.sort(candidates);
			process(0, candidates, target, list);
			return lists;
		}


		private void process(int start, int[] candidates, int target, List<Integer> list) {
			if (target < 0) {
				return;
			}
			if (target == 0) {
				lists.add(new ArrayList<>(list));
			} else {
				// 回溯
				for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
					list.add(candidates[i]);
					//因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
					process(i, candidates, target - candidates[i], list);
					list.remove(list.size() - 1);   //消除状态的
				}
			}
	}
}

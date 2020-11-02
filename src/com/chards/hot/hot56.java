package com.chards.hot;

import java.util.Arrays;

/**
 * @author 远 chards_
 * @FileName:hot56
 * @date: 2020-11-02 12:11
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class hot56 {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for (int[] interval : intervals) {
			// 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
			// 则不合并，直接将当前区间加入结果数组。
			if (idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			} else {
				// 反之将当前区间合并至结果数组的最后区间
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, idx + 1);
	}
}

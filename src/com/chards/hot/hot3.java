package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot3
 * @date: 2020-10-28 21:26
 * <p>
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class hot3 {

	public int lengthOfLongestSubstring(String s) {

		int[] nums = new int[256];
		int length = s.length(), res = -1, ans = 0;
		for (int i = 0; i < length; ) {
			if (res + 1 < length && nums[s.charAt(res + 1)] == 0) {
				res++;
				nums[s.charAt(res)]++;
			} else {
				nums[s.charAt(i)]--;
				i++;
			}
			ans = Math.max(ans, res - i + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		hot3 hot3 = new hot3();
		hot3.lengthOfLongestSubstring("abaa");
	}
}

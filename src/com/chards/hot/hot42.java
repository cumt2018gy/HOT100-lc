package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot42
 * @date: 2020-11-01 21:11
 * 42. 接雨水
 */
public class hot42 {
   // 接雨水 双指针问题
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		int left = 0, right = height.length - 1, res = 0;
		int l_max = height[0];
		int r_max = height[height.length - 1];
		while (left < right) {
			l_max = Math.max(l_max, height[left]);
			r_max = Math.max(r_max, height[right]);
			if (l_max < r_max) res += l_max - height[left++];
			else res += r_max - height[right--];
		}
		return res;
	}

	public static void main(String[] args) {
		hot42 hot42=new hot42();
		hot42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
	}
}

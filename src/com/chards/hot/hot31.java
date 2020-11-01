package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot31
 * @date: 2020-11-01 14:49
 * <p>
 * 31. 下一个排列
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class hot31 {

	public void nextPermutation(int[] nums) {
		int start = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				for (int j = nums.length - 1; j >= i; j--) {
					if (nums[j] > nums[i - 1]) {
						swap(nums, i - 1, j);
						start = i;
						break;
					}
				}
				break;
			}
		}
		for (int i = start; i < (start + nums.length) / 2; i++) {
			swap(nums, i, nums.length - i + start - 1);
		}

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		hot31 hot31=new hot31();
		hot31.nextPermutation(new int[]{4,3,2,1});
	}


}

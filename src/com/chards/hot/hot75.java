package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot75
 * @date: 2020-11-02 21:09
 * 75. 颜色分类  三路快排
 */
public class hot75 {
 //三路快排 一次扫描数组
	public void sortColors(int[] nums) {
		int l = -1;
		int r = nums.length;
		for (int i = 0; i < r; ) {
			if (nums[i] == 1) {
				i++;
			} else if (nums[i] == 2) {  //后置
				r--;
				int temp = nums[r];
				nums[r] = 2;
				nums[i] = temp;
			} else {  //前置
				l++;
				int temp = nums[l];
				nums[l] = 0;
				nums[i] = temp;
				i++;
			}
		}
	}


  //计数排序 两次扫描数组
	public void sortColors1(int[] nums) {
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) a++;
			else if (nums[i] == 1) b++;
			else if (nums[i] == 2) c++;
		}
		for (int i = 0; i < a; i++) {
			nums[i] = 0;
		}
		for (int i = a; i < b + a; i++) {
			nums[i] = 1;
		}
		for (int i = a + b; i < nums.length; i++) {
			nums[i] = 2;
		}
	}


}

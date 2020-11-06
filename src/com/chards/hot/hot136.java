package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot136
 * @date: 2020-11-06 23:27
 *
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class hot136 {

	public int singleNumber(int[] nums) {
		int single = 0;
		for (int num : nums) {
			single ^= num;
		}
		return single;
	}

	public static void main(String[] args) {
		hot136 hot136=new hot136();
		hot136.singleNumber(new int[]{4,1,2,1,2,4,4});
	}
}

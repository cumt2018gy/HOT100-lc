package com.chards.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 远 chards_
 * @FileName:hot17
 * @date: 2020-10-31 14:06
 * 17. 电话号码的字母组合
 */
public class hot17 {

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return new ArrayList<>();
		}
		List<String> res = new ArrayList<>();
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		search("", 0, res, map, digits);    //传入 拼接好的要加入到res中的字符串 ， 层次， 最终结果 ，map , 题中给的要求
		return res;
	}

	private void search(String sb, int index, List<String> res, Map<Character, String> map, String digits) {
		// 递归终止条件
		if (index == digits.length()) {
			res.add(sb);
			return;
		}
		//处理当前层
		String s = map.get(digits.charAt(index));
		for (int i = 0; i < s.length(); i++) {
			//进入下一层
			search(sb + s.charAt(i), index + 1, res, map, digits);
		}
	}

}

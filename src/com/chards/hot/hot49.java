package com.chards.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 远 chards_
 * @FileName:hot49
 * @date: 2020-11-02 11:49
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class hot49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) return new ArrayList<>();
		Map<String, List> map = new HashMap<>();
		for (String s : strs) {
			char[] sc = s.toCharArray();
			Arrays.sort(sc);
			String key = String.valueOf(sc);
			if (!map.containsKey(key)) map.put(key, new ArrayList());
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
	}
}

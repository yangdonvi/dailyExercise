package com.donvi.letcode.字符串;

import java.util.HashSet;
import java.util.Set;

//          给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//        示例 1:
//
//        输入: s = "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: s = "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: s = "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//        示例 4:
//
//        输入: s = ""
//        输出: 0
public class No3无重复字符的最长字串 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int end = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                charSet.remove(s.charAt(i-1));
            }
            while (end < s.length() && !charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                ++end;
            }
            max = Math.max(max, charSet.size());
        }
        return max;
    }


}

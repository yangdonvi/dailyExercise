package com.donvi.letcode.数组;

public class No242字母异位词 {
//    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//    示例 1:
//
//    输入: s = "anagram", t = "nagaram"
//    输出: true
//    示例 2:
//
//    输入: s = "rat", t = "car"
//    输出: false
//    说明:
//    你可以假设字符串只包含小写字母。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/valid-anagram
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    // 只有26个字母，用长度26的数组，类似hash表
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (table[t.charAt(i) - 'a'] -- == 0){
                return false;
            }
        }
        return true;

    }




}

package com.donvi.letcode.字符串;

public class No318最大单词长度乘积 {
//    给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
//
//    示例 1:
//
//    输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//    输出: 16
//    解释: 这两个单词为 "abcw", "xtfn"。
//    示例 2:
//
//    输入: ["a","ab","abc","d","cd","bcd","abcd"]
//    输出: 4
//    解释: 这两个单词为 "ab", "cd"。
//    示例 3:
//
//    输入: ["a","aa","aaa","aaaa"]
//    输出: 0
//    解释: 不存在这样的两个单词。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxProduct(String[] words) {
        int result = 0;
        int[] temp = new int[26];
        for(int i = 0; i< words.length - 1;i++){
            for (int k = 0; k < words[i].length(); k++) {
                temp[words[i].charAt(k)-'a']++;
            }
            for(int j = i+1; j<words.length;j++){
                boolean flag = true;
                for(int m = 0; m<words[j].length(); m++){
                    if(temp[words[j].charAt(m)-'a']>0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
            temp = new int[26];
        }
        return result;
    }


}

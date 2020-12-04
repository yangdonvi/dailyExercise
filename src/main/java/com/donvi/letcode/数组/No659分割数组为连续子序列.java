package com.donvi.letcode.数组;

import java.util.*;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/12/4
 * @Version: 1.0
 */
public class No659分割数组为连续子序列 {
    //    给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
//
//    如果可以完成上述分割，则返回 true ；否则，返回 false 。
//
//             
//
//    示例 1：
//
//    输入: [1,2,3,3,4,5]
//    输出: True
//    解释:
//    你可以分割出这样两个连续子序列 :
//            1, 2, 3
//            3, 4, 5
//             
//
//    示例 2：
//
//    输入: [1,2,3,3,4,4,5,5]
//    输出: True
//    解释:
//    你可以分割出这样两个连续子序列 :
//            1, 2, 3, 4, 5
//            3, 4, 5
//             
//
//    示例 3：
//
//    输入: [1,2,3,4,4,5]
//    输出: False
// 
//
//    提示：
//
//    输入的数组长度范围为 [1, 10000]


    // 贪心方法，遍历两次，时间复杂度O(n)
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int i : nums) {
            int count = countMap.getOrDefault(i, 0) + 1;
            countMap.put(i, count);
        }
        for (int i : nums) {
            int countI = countMap.getOrDefault(i, 0);
            if (countI > 0) {
                int countEndPreI = endMap.getOrDefault(i - 1, 0);
                if (countEndPreI > 0) {
                    countMap.put(i, countI - 1);
                    endMap.put(i - 1, countEndPreI - 1);
                    endMap.put(i, endMap.getOrDefault(i, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(i + 1, 0);
                    int count2 = countMap.getOrDefault(i + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(i, countI - 1);
                        countMap.put(i + 1, count1 - 1);
                        countMap.put(i + 2, count2 - 1);
                        endMap.put(i + 2, endMap.getOrDefault(i + 2, 0) + 1);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,4,5};
        System.out.println(isPossible(test));
    }

}

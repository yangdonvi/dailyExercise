package com.donvi.letcode.数组;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/12/10
 * @Version: 1.0
 */
public class No912排序数组 {
//    示例 1：
//
//    输入：nums = [5,2,3,1]
//    输出：[1,2,3,5]
//    示例 2：
//
//    输入：nums = [5,1,1,2,0,0]
//    输出：[0,0,1,1,2,5]
//             
//
//    提示：
//
//            1 <= nums.length <= 50000
//            -50000 <= nums[i] <= 50000
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sort-an-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    // 快排思路：
    // 左右边界相遇return
    // 取左基准值，ij指针指首尾
    // 当左右指针不等开始排
    // 以左为准向右走，左侧小于基准指针向右走
    // 以右为准向左右，右侧大于基准指针向左走
    // 都走不动交换左右指针对应位置
    // 指针相遇与交换基准
    //
    // 左递归
    // 右递归

    private void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int base = arr[left];
        int i = left, j = right;
        while (i != j) {
            while (i < j && base >= arr[i]) {
                i++;
            }
            while (i < j && base <= arr[j]) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);


    }

    /*private void quickSort(int[] arr, int left, int right){
        //先判断左边是否大于右边，如果大于，则结束方法
        if(left > right){
            return;
        }
        //定义基准值
        int base = arr[left];
        int i = left;
        int j = right;
        while(i != j){
            //先从右往左找
            while(arr[j] >= base && i < j){
                j--;
            }
            //再从左往右找
            while(arr[i] <= base && i < j){
                i++;
            }
            //这时j的位置是比基准值小的值，i的位置是比基准值大的值
            //交换他俩的位置
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //这时 i == j ，交换这个位置与基准值的值
        arr[left] = arr[i];
        arr[i] = base;
        //递归调用方法排序基准值左边的值
        quickSort(arr, left, i - 1);
        //排序右边的值
        quickSort(arr, j + 1, right);
    }
*/


}

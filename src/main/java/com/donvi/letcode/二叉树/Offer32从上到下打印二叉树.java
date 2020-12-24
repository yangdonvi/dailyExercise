package com.donvi.letcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32从上到下打印二叉树 {
//    从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//    例如:
//    给定二叉树: [3,9,20,null,null,15,7],
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    返回：
//            [3,9,20,15,7]
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}


}

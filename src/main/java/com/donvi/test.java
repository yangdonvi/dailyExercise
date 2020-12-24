package com.donvi;

public class test {

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

    public static void afterTravel(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        afterTravel(treeNode.left);
        afterTravel(treeNode.right);
        System.out.println(treeNode.val);

    }



}

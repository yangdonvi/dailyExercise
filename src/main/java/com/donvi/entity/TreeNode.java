package com.donvi.entity;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/1/19
 * @Version: 1.0
 */
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    int childNodeNum;

    public TreeNode(Integer val){
        this.val = val;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getChildNodeNum(){
        if (this.left != null){
            this.childNodeNum++;
        }
        if (this.right != null){
            this.childNodeNum++;
        }
        return this.childNodeNum;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

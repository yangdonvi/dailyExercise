package com.donvi.common;

import com.donvi.entity.TreeNode;
import com.donvi.entity.TreeNodeConstant;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/1/19
 * @Version: 1.0
 */
/**

    1
   / \
  2   3
 / \
4   5


 -----1
 ---/---\
 --2-----3
 -/-\---/-\
 4---5-6---7

*/

public class TreeNodeBox {

    public static int getAllNodeNum(TreeNode treeNode){
        if (treeNode == null){
            return TreeNodeConstant.ZERO;
        }
        return TreeNodeConstant.ONE + getAllNodeNum(treeNode.getLeft()) + getAllNodeNum(treeNode.getRight());
    }

    public static int getTreeDepth(TreeNode treeNode){
        if (treeNode == null){
            return TreeNodeConstant.ZERO;
        }
        return TreeNodeConstant.ONE + Math.max(getTreeDepth(treeNode.getLeft()), getTreeDepth(treeNode.getRight()));
    }

    public static void firstRecurs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        System.out.print(treeNode.getVal() + " ");
        firstRecurs(treeNode.getLeft());
        firstRecurs(treeNode.getRight());
    }

    public static void midRecurs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        midRecurs(treeNode.getLeft());
        System.out.print(treeNode.getVal() + " ");
        midRecurs(treeNode.getRight());
    }

    public static void afterRecurs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        afterRecurs(treeNode.getLeft());
        afterRecurs(treeNode.getRight());
        System.out.print(treeNode.getVal() + " ");
    }

    public static TreeNode invertTree(TreeNode treeNode){
        if (treeNode == null){
            return null;
        }
        TreeNode temp = invertTree(treeNode.getLeft());
        treeNode.setLeft(invertTree(treeNode.getRight()));
        treeNode.setRight(temp);
        return treeNode;
    }
}

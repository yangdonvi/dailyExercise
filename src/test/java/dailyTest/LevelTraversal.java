package dailyTest;

import com.donvi.common.TreeNodeBox;
import com.donvi.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Donvi Yang on 2020/4/7.
 */
public class LevelTraversal {


    /**

 -----1
 ---/---\
 --2-----3
 -/-\---/-\
 4--- - ---7

 */


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(2, treeNode1, null);
        TreeNode treeNode6 = new TreeNode(3, null, treeNode4);
        TreeNode treeNode7 = new TreeNode(1, treeNode5, treeNode6);
        TreeNodeBox.levelTraversal(treeNode7);
    }
}

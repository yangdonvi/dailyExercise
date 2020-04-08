package dailyTest;

import com.donvi.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Donvi Yang on 2020/4/7.
 */
public class LevelTraversal {

    public static void levelTraversal(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode;
        queue.offer(treeNode);
        TreeNode curLast = treeNode;
        TreeNode nextLast = null;
        int index = 1;
        System.out.print("第"+index+"行：");

        while (!queue.isEmpty()){
            currentNode = queue.poll();
            System.out.print(currentNode.getVal());
            if (currentNode.getLeft() != null){
                queue.offer(currentNode.getLeft());
                nextLast = currentNode.getLeft();
            }
            if (currentNode.getRight() != null){
                queue.offer(currentNode.getRight());
                nextLast = currentNode.getRight();
            }
            if (curLast.equals(currentNode) && !queue.isEmpty()){
                System.out.println();
                System.out.print("第"+ ++index +"行：");
                curLast = nextLast;
            }
        }

    }

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
        levelTraversal(treeNode7);
    }
}

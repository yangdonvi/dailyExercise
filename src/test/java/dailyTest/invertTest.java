package dailyTest;


import com.donvi.common.TreeNodeBox;
import com.donvi.entity.TreeNode;
import org.junit.Test;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/1/17
 * @Version: 1.0
 */
public class invertTest {

    /**

     -----1
     ---/---\
     --2-----3
     -/-\---/-\
     4---5-6---7

     -----1
     ---/---\
     --3-----2
     -/-\---/-\
     7---6-5---4

     */

    TreeNode treeNode1 = new TreeNode(4);
    TreeNode treeNode2 = new TreeNode(5);
    TreeNode treeNode3 = new TreeNode(6);
    TreeNode treeNode4 = new TreeNode(7);
    TreeNode treeNode5 = new TreeNode(2, treeNode1, treeNode2);
    TreeNode treeNode6 = new TreeNode(3, treeNode3, treeNode4);
    TreeNode treeNode7 = new TreeNode(1, treeNode5, treeNode6);

    @Test
    public void testFirstRecurs(){
        TreeNodeBox.firstRecurs(treeNode7);
    }

    @Test
    public void testMidRecurs(){
        TreeNodeBox.midRecurs(treeNode7);
    }

    @Test
    public void testAfterRecurs(){
        TreeNodeBox.afterRecurs(treeNode7);
    }

    @Test
    public void testInvertTree(){
        TreeNodeBox.invertTree(treeNode7);
        TreeNodeBox.firstRecurs(treeNode7);
    }

}

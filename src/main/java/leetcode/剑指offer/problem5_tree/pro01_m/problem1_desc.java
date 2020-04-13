package leetcode.剑指offer.problem5_tree.pro01_m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/23
 * 功能描述:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class problem1_desc {
    public static void main(String[] args) {
        // 中序遍历验证
        //TreeNode root = new TreeNode(3);
        //TreeNode treeNode9 = new TreeNode(9);
        //TreeNode treeNode20 = new TreeNode(20);
        //TreeNode treeNode15 = new TreeNode(15);
        //TreeNode treeNode7 = new TreeNode(7);
        //
        //root.left = treeNode9;
        //root.right = treeNode20;
        //treeNode20.left = treeNode15;
        //treeNode20.right = treeNode7;
        //ArrayList<Integer> list = new ArrayList<>();
        //
        //getMiddleSeqTreeArray(root,list);

        // 构建又子二叉树验证
        //int[] array = {1,2,3};
        //TreeNode treeNode = buildRightTree(array);
        int[] preorder = {1,2,4,5,8,9,3,6,10,7};
        int[] inorder = {4,2,8,5,9,1,6,10,3,7};
        Solution1 solution1 = new Solution1();
        solution1.buildTree(preorder, inorder);


    }

    public static Integer[] getMiddleSeqTreeArray(TreeNode treeNode, List<Integer> list) {
        middleSeqTree(treeNode, list);
        return list.toArray(new Integer[list.size()]);
    }

    private static void middleSeqTree(TreeNode treeNode, List<Integer> list) {
        if (Objects.isNull(treeNode)) {
            return;
        } else {
            middleSeqTree(treeNode.left, list);
            list.add(treeNode.val);
            middleSeqTree(treeNode.right,list);
        }
    }
    public static TreeNode buildRightTree(int[] preorder){
        TreeNode root = null;
        TreeNode current = null;
        for(int i = 0; i < preorder.length; i++){
            if(Objects.isNull(root)){
                root = new TreeNode(preorder[i]);
                current = root;
            }else{
                current.right = new TreeNode(preorder[i]);
                current = current.right;
            }
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

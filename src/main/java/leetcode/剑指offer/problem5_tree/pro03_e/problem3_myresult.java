package leetcode.剑指offer.problem5_tree.pro03_e;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/24
 * 功能描述:
 * 修改日期:2020/4/24
 * 修改描述:
 */
public class problem3_myresult {
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode leftTree = root.left;
        root.left = root.right;
        root.right = leftTree;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}

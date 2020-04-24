package leetcode.剑指offer.problem5_tree.pro04_e;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/24
 * 功能描述:
 * 修改日期:2020/4/24
 * 修改描述:
 */
public class problem4_otherresult {
}
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isLeftTreeEqualRightTree(root.left,root.right);

    }

    public boolean isLeftTreeEqualRightTree(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isLeftTreeEqualRightTree(left.left,right.right) && isLeftTreeEqualRightTree(left.right,right.left);
    }
}


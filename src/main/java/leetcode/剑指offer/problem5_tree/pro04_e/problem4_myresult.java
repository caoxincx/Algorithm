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
public class problem4_myresult {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if((root.left == null && root.right == null)) return true;
        if((root.left == null  && root.right != null) || (root.left != null  && root.right == null)) return false;
        else if(root.left.val != root.right.val) return false;

        return isLeftTreeEqualRightTree(root.left,root.right);

    }
    public boolean isLeftTreeEqualRightTree(TreeNode left,TreeNode right){
        boolean leftb = false;
        boolean rightb = false;
        if(left == null && right == null) return true;
        if(left != null && right != null){
            if(left.val != right.val) return false;
        }
        if((left.left != null && right.right == null) ||
                (left.right == null && right.left != null))return false;
        if((left.left == null && right.right != null) ||
                (left.right != null && right.left == null))return false;
        if(left.left == null && right.right == null){
            return isLeftTreeEqualRightTree(left.right,right.left);
        }
        if(left.right == null && right.left == null){
            return isLeftTreeEqualRightTree(left.left,right.right);
        }
        if(left.left != null && right.right != null){
            if(left.left.val == right.right.val){
                leftb = isLeftTreeEqualRightTree(left.left,right.right);
            }
        }else{
            return false;
        }
        if(left.right != null && right.left != null){
            if(left.right.val == right.left.val){
                rightb = isLeftTreeEqualRightTree(left.right,right.left);
            }
        }else{
            return false;
        }
        return leftb && rightb;
    }
}

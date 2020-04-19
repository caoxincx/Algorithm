package leetcode.剑指offer.problem5_tree.pro02_m;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/19
 * 功能描述:尝试递归
 * 修改日期:2020/4/19
 * 修改描述:
 */
public class problem2_otherresult {
}
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        if(isPartSame(A,B)) return true;
        else return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    private boolean isPartSame(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        if(A.val == B.val){
            return isPartSame(A.left,B.left) && isPartSame(A.right,B.right);
        }else{
            return false;
        }
    }

}

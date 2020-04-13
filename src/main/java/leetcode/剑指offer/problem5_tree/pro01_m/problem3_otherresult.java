package leetcode.剑指offer.problem5_tree.pro01_m;

import java.util.HashMap;
import java.util.Map;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/12
 * 功能描述:
 * 修改日期:2020/4/12
 * 修改描述:
 */
public class problem3_otherresult {
}
class Solution1 {
    private Map<Integer, Integer> reverses;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        // 可以不做判断，因为题目中给出的数据都是有效的
        if (preLen != inLen) {
            return null;
        }

        this.preorder = preorder;

        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        reverses = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            reverses.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
     */
    private TreeNode buildTree(int preL, int preR,
                               int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = reverses.get(pivot);

        // 这一步得画草稿，计算边界的取值，必要时需要解方程，并不难
        root.left = buildTree(preL + 1, (pivotIndex-inL)+preL, inL, pivotIndex - 1);
        root.right = buildTree((pivotIndex-inL)+preL+1, preR, pivotIndex + 1, inR);
        return root;
    }

}

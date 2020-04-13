package leetcode.剑指offer.problem5_tree.pro01_m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:我的答案不成功 求不出解
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem2_myresult {
    public static void main(String[] args) {
        int[] preOrder = {1,2,3};
        int[] inOrder = {2,3,1};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 创建一颗右子树
        TreeNode root = buildRightTree(preorder);
        // 进行调整
        ArrayList<Integer> list = new ArrayList();
        int[] isNeedAdjustArr = isNeedAdjust(inorder,getMiddleSeqTreeArray(root,list));
        while(Objects.nonNull(isNeedAdjustArr)){
            // 获取需要调整的元素
            TreeNode parent = getTreeNode(root,isNeedAdjustArr[0]);
            TreeNode child = getTreeNode(root,isNeedAdjustArr[1]);
            TreeNode childParent = getParentTreeNode(root, isNeedAdjustArr[1]);
            // 调整
            TreeNode pSrcLeftNode = parent.left;
            TreeNode cSrcRightNode = child.right;
            childParent.right = null;
            child.right = null;
            parent.left = child;
            child.left = pSrcLeftNode;
            childParent.right = cSrcRightNode;
            isNeedAdjustArr = isNeedAdjust(inorder,getMiddleSeqTreeArray(root,list));
        }
        return root;


    }

    public List<Integer> getMiddleSeqTreeArray(TreeNode treeNode, List<Integer> list) {
        list.clear();
        middleSeqTree(treeNode, list);
        return list;
    }

    private void middleSeqTree(TreeNode treeNode, List<Integer> list) {
        if (Objects.isNull(treeNode)) {
            return;
        } else {
            middleSeqTree(treeNode.left, list);
            list.add(treeNode.val);
            middleSeqTree(treeNode.right,list);
        }
    }

    public int[] isNeedAdjust(int[] inorder,List<Integer> list) {
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] != list.get(i)){
                return new int[]{list.get(i),inorder[i]};
            }
        }
        return null;
    }

    public TreeNode buildRightTree(int[] preorder){
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

    public TreeNode getTreeNode(TreeNode root,int val){
        TreeNode node = root;
        while(node != null){
            if(node.val == val){
                return node;
            }else{
                node = node.right;
            }
        }
        return null;
    }
    public TreeNode getParentTreeNode(TreeNode root,int val) {
        TreeNode node = root;
        if (node.val == val){
            return null;
        }
        while(Objects.nonNull(node.right)){
            if(node.right.val == val){
                return node;
            }else {
                node = node.right;
            }
        }
        return null;
    }

}

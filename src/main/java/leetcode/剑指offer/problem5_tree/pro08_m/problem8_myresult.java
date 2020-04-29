package leetcode.剑指offer.problem5_tree.pro08_m;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/29
 * 功能描述:
 * 修改日期:2020/4/29
 * 修改描述:
 */
public class problem8_myresult {
    public static void main(String[] args) {
       TreeNode treeNode1 = new TreeNode(1);
       TreeNode treeNode2 = new TreeNode(2);
       TreeNode treeNode3 = new TreeNode(3);
       TreeNode treeNode4 = new TreeNode(4);
       TreeNode treeNode5 = new TreeNode(5);
       TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode4.left = treeNode5;
        treeNode5.right = treeNode6;

        List<List<Integer>> lists = new Solution().pathSum(treeNode1, 6);
        System.out.println(lists);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int sum = 0;
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> queue = new LinkedList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList();
        this.sum = sum;
        leftOrder(root);
        return list;
    }
    public void leftOrder(TreeNode node) {
        if(node == null) return;
        queue.add(node.val);
        if((queue.stream().mapToInt(Integer::intValue).sum() == sum)
                && node.left == null
                && node.right == null) {
            this.list.add(copy(queue));

        }
        if(node.left != null) leftOrder(node.left);
        if(node.right != null) leftOrder(node.right);
        queue.removeLast();
    }

    public List<Integer> copy(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list) {
            newList.add(integer);
        }
        return newList;
    }
}

